package com.back.step8;

import java.util.Scanner;

public class ContentManager {
    ContentArray contentArray;
    Scanner scanner;

    ContentManager(){
        scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        contentArray = new ContentArray();
    }

    private void addContent(){
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();
        Content newContent = new Content(content, author);
        contentArray.add(newContent);
        System.out.println(newContent.getId() + "번 명언이 등록되었습니다.");
    }

    private int getNum(String num_str){
        String only_num_str;
        for (int i = 0; i< num_str.length(); i++){
            if (num_str.charAt(i)<'0' || num_str.charAt(i)>'9'){
                only_num_str = num_str.substring(0,i);
                int num = Integer.parseInt(only_num_str);
                return num;
            }
        }
        return Integer.parseInt(num_str);
    }

    private int getId(String str){
        String id_str = "id=";
        for (int i = 0 ; i< str.length(); i++){
            boolean found = false;
            for (int j = 0 ; j< id_str.length(); j++){
                if (str.charAt(i+j) != id_str.charAt(j)){
                    break;
                }
                found = true;
            }
            if (found){
                String sub_str = str.substring(i + id_str.length());
                int id = getNum(sub_str);
                return id;
            }
        }
        return Content.NULL_ID;
    }

    private void deleteContent(String str){
        int id = getId(str);
        if (id == Content.NULL_ID){
            System.out.println("ID를 입력하시오.");
            return;
        }
        boolean success = contentArray.removeContentById(id);
        if (success){
            System.out.println( id+"번 명언이 삭제되었습니다.");
        }else{
            System.out.println( id+"번 명언은 존재하지 않습니다.");
        }
    }

    private void editContent(String str){
        int id = getId(str);
        if (id == Content.NULL_ID){
            System.out.println("ID를 입력하시오.");
        }
        Content content = contentArray.getContentById(id);
        if (content == null){
            System.out.println( id+ "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + content.getContent());
        System.out.print("명언 : ");
        String content_str = scanner.nextLine().trim();
        System.out.println("작가(기존) : " + content.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();
        content.setContent(content_str);
        content.setAuthor(author);
    }

    public void run(){
        while (true){
            System.out.print("명령) ");
            String input = scanner.nextLine().trim();
            if (input.equals("종료")){
                break;
            } else if (input.equals("등록")){
                addContent();
            } else if (input.equals("목록")){
                contentArray.printContents();
            } else if (input.startsWith("삭제")){
                deleteContent(input);
            } else if (input.startsWith("수정")){
                editContent(input);
            }
        }
        return;
    }

}
