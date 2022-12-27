package laba8;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;

public class ServiceByMartaAndLialkouskaya {

    private final Printer printer = new Printer();
    private final Reader reader = new Reader();

    public void reverseAll(MySuperArrayList list){
        for (int i = 0; i < list.size(); i++) {
            list.set(i, new String((new StringBuilder(list.get(i)).reverse())));
        }
    }

    public void showDuplicatesWithCount(MySuperArrayList list){
        MySuperArrayList cloneList = new MySuperArrayList(list);
        while(cloneList.size()>0){
            String elem = cloneList.get(0);
            int oldSize = cloneList.size();
            while(cloneList.remove(elem));
            System.out.println(elem+" string appears "+ (oldSize - cloneList.size()) + " times");
        }
    }

    public void showCharsStatistic(MySuperArrayList list){
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        String str = new String(stringBuilder).replaceAll("\\s+", "");
        while(str.length()>0){
            String ch = str.substring(0, 1);
            String oldStr = str;
            str = str.replaceAll(ch, "");
            System.out.println(ch+" symbol appears "+ (oldStr.length() - str.length()) + " times");
        }
    }

    public int findStrIdBySubstring(MySuperArrayList list, String str){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).contains(str)){
                return i;
            }
        }
        return -1;
    }

    public void showStringLengths(MySuperArrayList list) {
        for (String s : list) {
            System.out.println(s.length());
        }
    }

    public void writeListToXml(MySuperArrayList list, String fileName) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("str", String.class);
        xstream.alias("strs", MySuperArrayList.class);

        printer.createFileAndWriteToIt(xstream.toXML(list), fileName);
    }

    public MySuperArrayList readFileToSuperListAndPrint(String fileName) throws IOException{
        MySuperArrayList mySuperArrayList = new MySuperArrayList();
        mySuperArrayList.addAll(reader.readFileToList(fileName));
        System.out.println("String from "+fileName);
        mySuperArrayList.forEach(System.out::println);
        return mySuperArrayList;
    }
}
