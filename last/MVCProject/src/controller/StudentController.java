package controller;
import java.util.ArrayList;
import model.StudentDTO;
public class StudentController {
    // 원래대로라면 데이터베이스가 따로 존재하므로
    // 이안에서는 데이터베이스와 통신하여
    // CRUD(Create, Retrieve, Update, Delete) 하는 기능만들어가면되지만
    // 우리는 데이터베이스가 따로 없으므로 이 안에 유사 데이터베이스 역할을 대신할
    // ArrayList 객체를 갖도록한다
    private ArrayList<StudentDTO> list; //StudentDTO클래스를 모아둔 ArrayList객체를선언
    private int nextId;
    
    //이 클래스의 생성자안에서 초기화를 해준다.
    //생성자란 해당 클래스의 변수가 초기화될때 호출되는 메소드
    public void makeConnection() {//DB가 있었다면 메잌커넥션 사용했을 것
        list = new ArrayList<>();   //초기화해서 생성자 값으로 저장?
                                    //다른 곳에서 부를때 초기화된 배열로 나타난다.
        nextId = 1;                 // 1로 생성자 값으로 저장
    }
    //1. 사용자로부터 입력받은 값을
    //   모델 객체로 전달받아서
    //   리스트에 추가하는 
    //   insert()메소드
    public void insert(StudentDTO s) {
        s.setId(nextId++); // 번호는 입력받는 것이 아니니까 여기서 처리를 해준다
        
        list.add(s);       // 해당객체를 list에 추가를 해준다
    }
    
    //2.학생전체목록을
    //  ArrayList 객체로 담아서 보내주는 selectAll() 메소드
    
        //얕은복사(ShallowCopy) vs 깊은 복사 (Deep copy)
        //얕은 복사란, 객체를 전달할 때 복사된 주소값을 그대로 넘겨주는 방법이다
        //이 방법의 경우, 간단하지만 볷사본관 원본이 주소값을 공유하므로
        //복사본의 수정을 가하면 원본도 수정이 된다라는 단점이 있다
        
        //깊은 복사란, 객체를 전달할 때 별개의 공간을 새로 만들어서
        //원본의 값만 복사하여 별개 공간에 저장하고 넘겨주는 방법이다
        //이 방법의 경우, 코드가 복잡해지지만 복사본과 원본의 주소값이 다르므로
        // 복사본의 수정이 원본에 반영되지 않는다라는 장점이 있다
        
        //딮카피문 알아두면 좋음
        
    public ArrayList<StudentDTO>selectAll(){ 
        ArrayList<StudentDTO> temp = new ArrayList<>();
        //새 배열(1번,2번,3번..배열에 저장해야하므로)을 선언해준다
        for(StudentDTO s : list) {              //반복돼서 차례대로 변수가 나온다
            StudentDTO tempS = new StudentDTO();//StudentDTO클래스의 tempS 객체를 선언한다
            tempS.setId(s.getId());             //변수tempS에 차례대로 나오는 변수의 값들이 저장이된다
            tempS.setName(s.getName());         
            tempS.setKorean(s.getKorean());
            tempS.setEnglish(s.getEnglish());
            tempS.setMath(s.getMath());
            temp.add(tempS);                    
            //차례대로 나온 tempS의 값들이 temp배열(1번학생정보, 2번학생정보,...)에 저장이 된다.
        }
        return temp;                            //temp배열값을 리턴한다.
    }
    
    //3. 사용자가 선택한 번호의 학생을 리턴하는 
    //   selectOne()
    public StudentDTO selectOne(int id) {
        for(StudentDTO s : list) {  //반복돼서 차례대로 나온다
            if(id == s.getId()) {   //파라미터로 들어온 id가 위의 순서s와 같으면
                StudentDTO temp = new StudentDTO();
                //StudentDTO클래스에 템프값선언 
                //배열이 필요없는 번호 하나의 값이 나오는 거라서  배열선언은 하지 않는다
                temp.setId(s.getId());    //그 템프값에 번호에 해당하는 정보들을 저장한다
                temp.setName(new String(s.getName()));
                temp.setKorean(s.getKorean());
                temp.setEnglish(s.getEnglish());
                temp.setMath(s.getMath());
                
                return temp;//템프(정보들)를 리턴한다
            }
        }
        return null;//사용자가 잘못된 번호를 선택한경우 널이 리턴되도록
    }
    
    //4. 사용자가 수정한 정보를 담은 StudentDTO 객체를
    //   list에 반영(저장)하는
    //   update()
    public void update(StudentDTO s) { 
        // 수정된 정보를 받아서 리스트에 저장할 것으므로 파라미터에 StudentDTO s를 넣는다
        int index = list.indexOf(s);
        //파라미터로 들어온 객체(사용자가 수정하고 넘어온 정보=s)가 
        //배열에서 몇번째인지(몇번째 학생인지) 알아내어 변수index에 저장한다
        list.set(index, s);//인덱스번에 객체값(수정하고 넘어온정보s)을 배열에저장한다.
    }
    
    //5. 사용자가 삭제할 번호를 보내주면
    //   list에서 실제로 삭제하는
    //   delete()
    public void delete(int id) {
        StudentDTO s= new StudentDTO();//새 객체 선언
        s.setId(id);//파라미터로 들어온 변수(번호)를s에 저장한다.
        list.remove(s);//그 번호의인덱스 값을 삭제한다.
        
    }
}
