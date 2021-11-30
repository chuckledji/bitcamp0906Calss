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
    var regForm = document.getElementById('regForm');
    var userid = document.querySelector('#userid');                     //캐스팅(onload함수 안에서 실행되어야해서 밖으로 꺼냈다)
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var username = document.querySelector('#username');



    //-------------------------------------입력---------------------------------------------
    //이벤트생성 : 입력
    regForm.onsubmit = function(){  //submit(등록)이 눌리면 실행되는 이벤트함수(캐스팅한 regForm에 이벤트를 설정 )
         
        //유효성검사--------------------------------------------------------------
        //아이디검사 : 공백, 문자열의 개수 4~12, 서버통신(비동기 통신) 아이디 중복여부
        if(userid.value.trim().length==0){
            //msgid 캐스팅 => 문자열추가
            document.querySelector('#msgid').innerHTML='아이디를 입력해주세요.';
            
            return false;//문제발생했으니, 객체저장처리가 되면 안되니까
        }else if(!(userid.value.trim().length>3 && userid.value.trim().length<13)){
            document.querySelector('#msgid').innerHTML='4~12자리까지만 입력 가능합니다.';
            return false;
        }
        //비밀번호검사 : 공백, 4~20자
        if(pw.value.trim().length==0){
            document.querySelector('#msgpw').innerHTML='비밀번호를 입력해주세요.';
            return false;
        }else if(!(pw.value.trim().length>4 && pw.value.trim().length<21)){
            document.querySelector('#msgpw').innerHTML='4~20자리까지만 입력 가능합니다.';
        }
        //비밀번호확인 : 공백, 비밀번호와 일치여부
        if(repw.value.trim().length==0){
            document.querySelector('#msgrepw').innerHTML='비밀번호 확인이 필요합니다.';
            return false;
        }else if(repw.value!=pw.value){
            document.querySelector('#msgrepw').innerHTML='비밀번호가 일치하지 않습니다.';
            return false;
        }
        //이름검사 : 공백, 2자이상
        if(username.value.trim().length==0){
            document.querySelector('#msgname').innerHTML='이름을 입력해주세요.';
            return false;
        }else if(username.value.trim().length<2){
            document.querySelector('#msgname').innerHTML='이름은 2자이상 입력해주세요.';
            return false;
        }


        //입력 후--------------------------------------------------------------------
        var member = new Member(userid.value, pw.value, username.value);   //객체생성
        console.log('member', member);                                      //객체확인
        //객체를 배열에 저장
        members.push(member);
        console.log('members', members);

        //저장
        localStorage.setItem('members', JSON.stringify(members));

        //입력한 form초기화
        this.reset();     //this : 이벤트가 발생한 객체 => regform

        //회원리스트 갱신
        setMemberList();

        return false;
    }

    //입력 폼에 focus가 들어가면 아래 경고메세지가 삭제(공백으로)   //이벤트를 따로 하는아유 따로 캐스팅 되는 것이므로?
    userid.addEventListener('focus', function(){
        document.querySelector('#msgid').innerHTML='';
    });
    pw.addEventListener('focus', function(){
        document.querySelector('#msgpw').innerHTML='';
    });
    repw.addEventListener('focus', function(){
        document.querySelector('#msgrepw').innerHTML='';
    });
    username.addEventListener('focus', function(){
        document.querySelector('#msgename').innerHTML='';
    });



    //-------------------------------------수정---------------------------------------------
    //수정 폼의 데이터 캐스팅
    var editForm = document.querySelector('#editForm');
    var index = document.querySelector('#index');
    var epw = document.querySelector('#epw');
    var erepw = document.querySelector('#erepw');
    var ename = document.querySelector('#ename');
    var resetBtn = document.querySelector('#resetBtn');

    //수정 폼 이벤트 설정(수정버튼이 눌렸을 때)
    editForm.onsubmit = function(){
        

        //유효성검사-------------------------------------------------------
        //index값 존재 유무 확인***
        if(index.value.trim().length==0){
            alert('유효한 인덱스값이 아닙니다.\n프로그램을 다시 시작하세요');
            return false;
        }
        //epw 공백, 문자사이즈
        if(epw.value.trim().length==0){
            alert('비밀번호를 입력해주세요');
            epw.focus();
            return false;
        }else if(!(epw.value.trim().length>3 && epw.value.trim().length<21)){
            alert('4~20자리까지만 입력 가능합니다.');
            epw.focus();
            return false;
        }
        //erepw 공백, epw 일치여부
        if(erepw.value.trim().length==0){
            alert('비밀번호를 입력해주세요');
            erepw.focus();
            return false;
        }else if(!(erepw.value==epw.value)){
            alert('비밀번호가 일치하지않습니다.\n다시 입력해주세요');
            erepw.focus();
            return false;
        }
        //ename 공백, 문자사이즈
        if(ename.value.trim().length==0){
            alert('이름을 입력해주세요');
            ename.focus();
            return false;
        }else if(ename.value.trim().length<2){
            alert('이름은 2자 이상 입력해주세요');
            ename.focus();
            return false;
        }

        //입력 후--------------------------------------------------------------------
        //index위치의 배열의 요소에 현재 캐스팅한 데이터를 입력
        members[index.value].pw=epw.value.trim();
        members[index.value].username=ename.value.trim();

        //저장
        localStorage.setItem('members', JSON.stringify(members));

        //화면 갱신
        setMemberList();

        alert('정보수정이 완료되었습니다.');
        
        //수정폼 영역 비노출처리
        editformClose();
        
        
        return false;
    }

    //수정폼의 초기화버튼
    resetBtn.onclick = function(){
        epw.value=members[index.value].pw;          //원래입력되어있던 값으로 돌아가도록한다.
        erepw.value=members[index.value].pw;
        ename.value=members[index.value].username;
    }
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
        for(let i=0; i<members.length; i++){
            list += '<tr>';
        list += '   <td>' + i + '</td>';
        list += '   <td>' + members[i].userid + '</td>';
        list += '   <td>' + members[i].pw + '</td>';
        list += '   <td>' + members[i].username + '</td>';
        list += '   <td><a href="javascript:editMemberForm('+i+')">수정</a> | <a href="javascript:deleteMember('+i+')">삭제</a></td>';
        list += '</tr>';
        }
    }
    //tbody캐스팅
    document.querySelector('#memberlist>table>tbody').innerHTML=list;
}



//수정폼입력 함수 : 클릭한 인덱스의 데이터가 폼에 입력되어있어야한다.(수정할것이므로)
function editMemberForm(index){
    //수정폼이 노출되어야 한다
    document.getElementById('editFormArea').style.display='block';

    var member = members[index];

    document.querySelector('#index').value=index;
    document.querySelector('#eid').value=member.userid;
    document.querySelector('#epw').value=member.pw;
    document.querySelector('#erepw').value=member.repw;
    document.querySelector('#ename').value=member.username;
}


//수정폼을 닫는함수
function editformClose(){
    document.querySelector('#editFormArea').style.display = 'none';
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



