package com.back.step8;

public class ContentArray {

    private Content[] contents = null;
    private final static int DEFAULT_SIZE = 10;
    private int current_size;
    private int current_index;
    private int content_id = 0;

    ContentArray() {
        contents = new Content[DEFAULT_SIZE];
        current_size = DEFAULT_SIZE;
        current_index = 0;
    }

    public void add(Content content) {
        if (current_index == current_size) {
            Content[] pre_contents = contents;
            int new_size = current_size << 1;
            contents = new Content[new_size];
            System.arraycopy(pre_contents, 0, contents, 0, current_size);
            current_size = new_size;

        }
        content.setID(++content_id);
        contents[current_index++] = content;
    }

    public void printContents(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = current_index -1; i>=0; i--){
            System.out.print(contents[i].getId());
            System.out.print(" / ");
            System.out.print(contents[i].getAuthor());
            System.out.print(" / ");
            System.out.println(contents[i].getContent());
        }
    }

    /**
     * removes an item of array and shift left all items next to it
     * @param id
     * @return shows success or fail on remove
     */
    public boolean removeContentById(int id){
        int index = getContentIndexByID(id);
        if (index == -1){
            return false;
        }
        for (int i = index; i< current_index-1;i++){
            contents[i] = contents[i+1];
        }
        contents[current_index-1] = null;
        current_index--;
        return true;
    }

    private int getContentIndexByID(int id){
        int index = -1;
        for (int i = 0; i < current_index; i++){
            if (contents[i].getId() == id){
                index = i;
                break;
            }
        }
        return index;
    }

    public Content getContentById(int id){
        int index = getContentIndexByID(id);
        if (index == -1){
            return null;
        }
        return contents[index];
    }

}
