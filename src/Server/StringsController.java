package Server;

public class StringsController
{
    public static String translate(String message){
        StringBuilder resultStr = new StringBuilder();
        String[] words = message.split(" ");
        for (String word : words) {
            resultStr.append(convert(word));
            resultStr.append(" ");
        }
        resultStr.deleteCharAt(resultStr.length()-1);
        return resultStr.toString();
    }
    private static String convert(String message) {
        char[] ru = {'й','ц','у','к','е','н','г','ш','щ','з','х','ъ','ф','ы','в','а','п','р','о','л','д','ж','э','я','ч','с','м','и','т','ь','б','ю','.','Й','Ц','У','К','Е','Н','Г','Ш','Щ','З','Х','Ъ','Ф','Ы','В','А','П','Р','О','Л','Д','Ж','Э','Я','Ч','С','М','И','Т','Ь','Б','Ю','.'};
        char[] en = {'q','w','e','r','t','y','u','i','o','p','[',']','a','s','d','f','g','h','j','k','l',';','\'','z','x','c','v','b','n','m',',','.','/','Q','W','E','R','T','Y','U','I','O','P','[',']','A','S','D','F','G','H','J','K','L',';','\'','Z','X','C','V','B','N','M',',','.','/'};
        StringBuilder builder = new StringBuilder();
        loop:
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < ru.length; j++ ) {
                if (message.charAt(i) == ru[j]) {
                    builder.append(en[j]);
                    continue loop;
                }
            }
            for (int j = 0; j < en.length; j++ ) {
                if (message.charAt(i) == en[j]) {
                    builder.append(ru[j]);
                    continue loop;
                }
            }
        }
        return builder.toString();
    }

    public static String caps(String message) {
        char[] charArray = message.toCharArray();
        for(int i = 0; i < message.length();i++){
            if (Character.isUpperCase(message.charAt(i))){
                charArray[i]=Character.toLowerCase(message.charAt(i));
            } else {
                charArray[i]=Character.toUpperCase(message.charAt(i));
            }
        }
        message = new String(charArray);
        return message;
    }
}
