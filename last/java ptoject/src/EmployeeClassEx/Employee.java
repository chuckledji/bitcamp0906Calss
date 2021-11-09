package EmployeeClassEx;
//사원정보입력에 필요한 클래스
public class Employee {

    //필드
    //사원번호
    private int id;
    //사원이름
    private String name;
    //사원부서
    private String department;
    //사원직급
    private String position;
    //사원이메일
    private String email;
    //사원연락처
    private int phone;
   
    
    
    //메소드
    //필드에 대한 getter/setter메소드
    //id
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    //name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //department
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    //position
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    //email
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    //phone
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public int getPhone() {
        return phone;
    }
        
    //public boolean
    public boolean equals(Object o) {
        if(o instanceof Employee) {
            Employee e = (Employee)o;
            if(id == e.id){
                return true;
            }
        }return false;
    }
    
    //출력용 메소드
    public void printInfo() {
        System.out.printf("--------s% 사원정보---------", department);
        System.out.printf("사원번호: d% 이름: s% 부서: s%직급: s%\n연락처- 이메일: s% 전화번호: d%", id, name, position, email, phone);
        System.out.println("-----------------------");
    }
    
    
    
    
    
    
    
    
    
    
    
}
