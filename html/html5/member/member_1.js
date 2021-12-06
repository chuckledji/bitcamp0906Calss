//회원정보를 저장할 배열 생성
var members= [];


$(document).ready(function(){

    //회원리스트 갱신
    //로컬스토리지에 데이터가 존재 하는지 확인후 처리
    //getItem(key) 데이터가 없으면 null반환
    if(localStorage.getItem('members')){
        //not null => 저장되어있는 JSON문자열을 자바스크립트의 배열로 변환
        members = JSON.parse(localStorage.getItem('members'));
    }else{
        //null => 비어있는 배열을 저장
        localStorage.setItem('members', JSON.stringify(members));   //비어있는걸 저장하는 이유는 뭐지?
    }

    console.log(members);
    setMemberList();

    
    //데이터 캐스팅 => 객체로 만듦 => 배열에 저장
    //var regForm = document.getElementById('regForm'); 2021.12.02 제이쿼리로 객체 전부 대체
    var regForm = $('#regForm');
    var userid =$('#userid');                   //캐스팅(onload함수 안에서 실행되어야해서 밖으로 꺼냈다)    var pw = document.querySelector('#pw');
    var pw = $('#pw');
    var repw = $('#repw');
    var username = $('#username');



    //-------------------------------------입력---------------------------------------------
    //이벤트생성 : 입력
    regForm.submit(function(){  //regforom.onsubmit=function(){}2021.12.02 제이쿼리로대체
         
        //유효성검사--------------------------------------------------------------
        //아이디검사 : 공백, 문자열의 개수 4~12, 서버통신(비동기 통신) 아이디 중복여부  //val()사용자가입력한value속성값을 반환
        if(userid.val().trim().length==0){
            //msgid 캐스팅 => 문자열추가
            $('#msgid').html('아이디를입력해주세요');
            //document.querySelector('#msgid').innerHTML='아이디를 입력해주세요.';
            
            return false;//문제발생했으니, 객체저장처리가 되면 안되니까
        }else if(!(userid.val().trim().length>3 && userid.val().trim().length<13)){
            $('#msgid').html('4~12자리까지만 입력 가능합니다.');
            //document.querySelector('#msgid').innerHTML='4~12자리까지만 입력 가능합니다.';
            return false;
        }
        //비밀번호검사 : 공백, 4~20자
        if(pw.val().trim().length==0){
            $('#msgpw').html('비밀번호를 입력해주세요.');
            //document.querySelector('#msgpw').innerHTML='비밀번호를 입력해주세요.';
            return false;
        }else if(!(pw.val().trim().length>4 && pw.val().trim().length<21)){
            $('#msgpw').html('4~20자리까지만 입력 가능합니다.');
            //document.querySelector('#msgpw').innerHTML='4~20자리까지만 입력 가능합니다.';
        }
        //비밀번호확인 : 공백, 비밀번호와 일치여부
        if(repw.val().trim().length==0){
            $('#msgrepw').html('비밀번호 확인이 필요합니다.');
            //document.querySelector('#msgrepw').innerHTML='비밀번호 확인이 필요합니다.';
            return false;
        }else if(repw.val()!=pw.val()){
            $('#msgrepw').html('비밀번호가 일치하지 않습니다.');
            //document.querySelector('#msgrepw').innerHTML='비밀번호가 일치하지 않습니다.';
            return false;
        }
        //이름검사 : 공백, 2자이상
        if(username.val().trim().length==0){
            $('#msgname').html('이름을 입력해주세요');
            //document.querySelector('#msgname').innerHTML='이름을 입력해주세요.';
            return false;
        }else if(username.val().trim().length<2){
            $('#msgname').html('이름은 2자이상 입력해주세요.');
            //document.querySelector('#msgname').innerHTML='이름은 2자이상 입력해주세요.';
            return false;
        }


        //입력 후--------------------------------------------------------------------
        var member = new Member(userid.val(), pw.val(), username.val());   //객체생성
        console.log('member', member);                                      //객체확인
        //객체를 배열에 저장
        members.push(member);
        console.log('members', members);

        //저장
        localStorage.setItem('members', JSON.stringify(members));

        //입력한 form초기화
        regForm[0].reset();     //제이쿼리적용하면 this가 적용이 안된다. 그래서 그냥 자바스크립트의 다른방법으로 함.

        //회원리스트 갱신
        setMemberList();

        return false;
    });

    //입력 폼에 focus가 들어가면 아래 경고메세지가 삭제(공백으로)   //이벤트를 따로 하는아유 따로 캐스팅 되는 것이므로?
    // userid.addEventListener('focus', function(){
    //     document.querySelector('#msgid').innerHTML='';
    // });
    userid.focusin(function(){
        $('#msgid').html('');
    });
    // pw.addEventListener('focus', function(){
    //     document.querySelector('#msgpw').innerHTML='';
    // });
    pw.focusin(function(){
        $('#msgpw').html('');
    });
    // repw.addEventListener('focus', function(){
    //     document.querySelector('#msgrepw').innerHTML='';
    // });
    repw.focusin(function(){
        $('#msgrepw').html('');
    });
    // username.addEventListener('focus', function(){
    //     document.querySelector('#msgename').innerHTML='';
    // });
    username.focusin(function(){
        $('#msgname').html('');
    });
    


    //-------------------------------------수정---------------------------------------------
    //수정 폼의 데이터 캐스팅
    var editForm = $('#editForm');
    var index = $('#index');
    var epw = $('#epw');
    var erepw = $('#erepw');
    var ename = $('#ename');
    var resetBtn = $('#resetBtn') //document.querySelector('#resetBtn'); 2021.12.02전부 제이쿼리로 대체

    //수정 폼 이벤트 설정(수정버튼이 눌렸을 때)
    //editForm.onsubmit = function(){})
    editForm.submit(function(){
        

        //유효성검사-------------------------------------------------------
        //index값 존재 유무 확인***
        if(index.val().trim().length==0){
            alert('유효한 인덱스값이 아닙니다.\n프로그램을 다시 시작하세요');
            return false;
        }
        //epw 공백, 문자사이즈
        if(epw.val().trim().length==0){
            alert('비밀번호를 입력해주세요');
            epw[0].focus();
            return false;
        }else if(!(epw.val().trim().length>3 && epw.val().trim().length<21)){
            alert('4~20자리까지만 입력 가능합니다.');
            epw[0].focus();
            return false;
        }
        //erepw 공백, epw 일치여부
        if(erepw.val().trim().length==0){
            alert('비밀번호를 입력해주세요');
            erepw[0].focus();
            return false;
        }else if(!(erepw.val()==epw.val())){
            alert('비밀번호가 일치하지않습니다.\n다시 입력해주세요');
            erepw[0].focus();
            return false;
        }
        //ename 공백, 문자사이즈
        if(ename.val().trim().length==0){
            alert('이름을 입력해주세요');
            ename[0].focus();
            return false;
        }else if(ename.val().trim().length<2){
            alert('이름은 2자 이상 입력해주세요');
            ename[0].focus();
            return false;
        }

        //입력 후--------------------------------------------------------------------
        //index위치의 배열의 요소에 현재 캐스팅한 데이터를 입력
        members[index.val()].pw=epw.val().trim();
        members[index.val()].username=ename.val().trim();

        //저장
        localStorage.setItem('members', JSON.stringify(members));

        //화면 갱신
        setMemberList();

        alert('정보수정이 완료되었습니다.');
        
        //수정폼 영역 비노출처리
        editformClose();
        
        
        return false;
    });

    //수정폼의 초기화버튼
    resetBtn.click(function(){  //resetBtn.onclick = function(){}; 제이쿼리로 대체 2021.12.02
        epw.val(members[index.val()].pw);          //원래입력되어있던 값으로 돌아가도록한다.
        erepw.val(members[index.val()].pw);
        ename.val(members[index.val()].username);
        //ename.value=members[index.value].username;
    });
    
    
});



//-------------------------------------기능함수-------------------------------------------
//기능함수들은 전역형태로 정의


//생성자함수 : 데이터 저장하는 객체 생성하는 함수
function Member(userid, pw, username){
    this.userid=userid;
    this.pw=pw;
    this.username=username;
}


//JSON => JS object {}
//출력함수 : 회원정보리스트를 출력
function setMemberList(){
    //화면을 갱신할 html
    var list = '';
    list += '<tr>';
    list += '   <th>순번</th>';
    list += '   <th>아이디</th>';
    list += '   <th>비밀번호</th>';
    list += '   <th>이름</th>';
    list += '   <th>관리</th>';
    list += '</tr>';

    if(members.length==0){
        list+= '<tr><td colspan ="5">저장된 데이터가 없습니다.</td></tr>';
    }else{
        // for(let i=0; i<members.length; i++){
        //     list += '<tr>';
        // list += '   <td>' + i + '</td>';
        // list += '   <td>' + members[i].userid + '</td>';
        // list += '   <td>' + members[i].pw + '</td>';
        // list += '   <td>' + members[i].username + '</td>';
        // list += '   <td><a href="javascript:editMemberForm('+i+')">수정</a> | <a href="javascript:deleteMember('+i+')">삭제</a></td>';
        // list += '</tr>';
        // }
        $.each('members', function(index, item){    //제이쿼리로 대체 2021.12.02
            list += '<tr>';
        list += '   <td>' + index + '</td>';
        list += '   <td>' + item.userid + '</td>';
        list += '   <td>' + item.pw + '</td>';
        list += '   <td>' + item.username + '</td>';
        list += '   <td><a href="javascript:editMemberForm('+index+')">수정</a> | <a href="javascript:deleteMember('+index+')">삭제</a></td>';
        list += '</tr>';s
        });
    }
    //tbody캐스팅
    $('#memberlist>table>tbody').html(list);
    //document.querySelector('#memberlist>table>tbody').innerHTML=list;
}



//수정폼입력 함수 : 클릭한 인덱스의 데이터가 폼에 입력되어있어야한다.(수정할것이므로)
function editMemberForm(index){
    //수정폼이 노출되어야 한다
    $('#editFormArea').css('display', 'block');
    //document.getElementById('editFormArea').style.display='block';  //제이쿼리로 대체 2021.12.02

    var member = members[index];

    //document.querySelector('#index').value=index;
    $('#index').val(index);
    //document.querySelector('#eid').value=member.userid;
    $('#eid').val(member.userid);
    //document.querySelector('#epw').value=member.pw;
    $('#epw').val(member.pw);
    //document.querySelector('#erepw').value=member.repw;
    $('#erepw').val(member.repw);
    //document.querySelector('#ename').value=member.username;
    $('#ename').val(member.name);
}


//수정폼을 닫는함수
function editformClose(){
    //document.querySelector('#editFormArea').style.display = 'none';  //제이쿼리로 대체 2021.12.02
    $('#editFormArea').css('display', 'none');
}



//배열의 데이터를 삭제하는 함수
function deleteMember(index){
    //배열의 요소를 삭제 : splice(index, count)

    if(confirm('정말 삭제하시겠습니까?')){
        members.splice(index, 1);

        //저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('삭제되었습니다.');

        //리스트 갱신
        setMemberList();
    }
}
//제이슨형식으로저장,화면갱신위주,가급적단일페이지로해결

