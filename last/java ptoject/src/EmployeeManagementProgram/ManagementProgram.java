package EmployeeManagementProgram;

import java.util.Scanner;
import java.util.ArrayList;

import EmployeeClassEx.Employee;
import util.ScannerUtil2;

public class ManagementProgram {
    private static ArrayList<Employee> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;
    
    //1.메인 메소드
    public static void main(String[] args) {
        System.out.println("AA사 사원 관리 프로그램");
        System.out.println("실행할 메뉴를 선택해주세요");
        System.out.println("------------------------");
        showMenu();
    }
    
    //2.메뉴 출력메소드
    //입출력을 선택한다
    private static void showMenu() {
       
        String message = new String("1. 사원등록 2. 사원정보 출력 3. 프로그램 종료");
        while(true) {
            int userChoice = ScannerUtil2.nextInt(scanner, message);
            if(userChoice == 1) {
                //부서별사원등록메소드
                insert();
            }else if(userChoice == 2) {
                //사원정보 목록 출력메소드
                printList();
            }else if(userChoice == 3) {
                //프로그램종료
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                break;
            }
        }
    }
    
   
    //3.사원등록메소드
    private static void insert() {
        String message;
        Employee e = new Employee();
        
        //입력
        e.setId(nextId++);
        
        message = new String("이름:");
        e.setName(ScannerUtil2.nextLine(scanner, message));
        
        message = new String("부서:");
        e.setDepartment(ScannerUtil2.nextLine(scanner, message));
        
        message = new String("직급:");
        e.setPosition(ScannerUtil2.nextLine(scanner, message));
        
        message = new String("이메일:");
        e.setEmail(ScannerUtil2.nextLine(scanner, message));
        
        message = new String("전화번호:\n-없이 숫자만 입력하시오");
        e.setPhone(ScannerUtil2.nextInt(scanner, message));
        
        list.add(e);
    }
    
    //4.사원목록출력메소드
    private static void printList() {
        if(list.isEmpty()) {
            System.out.println("입력된 정보 없음");
        }else {
            for(int i =0; i < list.size(); i++) {
                Employee e = list.get(i); //여기서 에러가 나는 것 같은데 이유를 모르겠습니다
            }
            for (Employee e : list) {
                System.out.printf("%d. %s\n", e.getId(), e.getName());
            }
            String message = new String("상세보기할 사원의 번호나 뒤로 가려면 0을 누르시오.");
            int userChoice = ScannerUtil2.nextInt(scanner, message);
            
            while (userChoice != 0 && retrieve(userChoice) == null) {
                System.out.println("잘못된 번호 입력");
                userChoice = ScannerUtil2.nextInt(scanner, message);
                
            }
            if(userChoice != 0) {
                printOne(userChoice);
            }
            
        }
    }
    
    //5.출력메소드
    private static Employee retrieve(int id) {
        Employee e = new Employee();
        e.setId(id);
        
        int index = list.indexOf(e);
        
        if(index != -1) {
            return list.get(index);
         }
        return null;
    }
    //6.사원개별보기메소드
    private static void printOne(int id) {
        Employee e = retrieve(id);
        
        e.printInfo();
        
        String message = new String("1. 정보수정 2. 정보삭제 3. 돌아가기");
        int userChoice = ScannerUtil2.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            //수정메소드
            update(id);
       }else if(userChoice == 2) {
           //삭제메소드
           delete(id);
       }else if(userChoice == 3) {
           printList();
       }
    }
    //7.수정메소드
    private static void update(int id) {
        Employee e = retrieve(id);
        String message;
        
        message = new String("부서:");
        e.setDepartment(ScannerUtil2.nextLine(scanner, message));
       
        message = new String("직급:");
        e.setPosition(ScannerUtil2.nextLine(scanner, message));
        
        message = new String("이메일:");
        e.setEmail(ScannerUtil2.nextLine(scanner, message));
        
        message = new String("전화번호:\n-없이 숫자만 입력하시오");
        e.setPhone(ScannerUtil2.nextInt(scanner, message));
        
        printOne(id);
    }
    //8.삭제메소드
    private static void delete(int id) {
        Employee e = retrieve(id);
        String message = new String("삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil2.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            list.remove(e);
            printList();
            
        }else {
            printOne(id);
        }
    }
    
    
    
    
}
