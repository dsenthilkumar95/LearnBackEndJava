package com.comcast.javaBasics;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringExplore {
    public static void main(String[] args){

        String s1 = "Senthil";
        String s = "Senthil"; // This will search for "Senthil" in String constant pool and if already present it points to the same.
        String s2 = "Saravanan";
        System.out.println(s2.indexOf("ar"));
        System.out.println(s2.lastIndexOf('a'));

//        Get charater a particular index from 0 to String length - 1
        System.out.println("String starts with -> " + s1.charAt(0));
        System.out.println("String ends with -> " + s1.charAt(s1.length()-1));

        // Getting int stream of chars from string and working on it.
        String s3 = "abcdefghz";
        IntStream charStream = s3.chars();
        charStream.forEach(i -> {
            System.out.println(i + " -> " + new String(Character.toChars(i)));
        });
        String s4 = "ABCDEFGHZ";
        IntStream charStreamCap = s4.chars();
        charStreamCap.forEach(i -> {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" -> ");
            sb.append(Character.toChars(i));
            System.out.println(sb.toString());
            //System.out.println(i + " -> " + Character.toChars(i));
            // This is not working as this gives only the charater object Id
        });

        String s5 = "*sen*thi*l*";
        String[] s5split = s5.split("\\*");
        // Here split generated empty string for first position, but not produces empty string for end position
        Stream.of(s5split).forEach(i -> System.out.println("-" + i + "-"));
        //System.out.println("<asperaOverrides>\n\t<override sourcePath=\"ftp://newa-fng-fx.ftp-library.sea1.theplatform.com/outbound\">\n\t\t<target>\n\t\t\t<path>fasp://aspera.soap.prod.theplatform.com:33001</path>\n\t\t\t<username>fx_outbound01</username>\n\t\t\t<password>mHfxrw99yu</password>\n\t\t\t<assetType>MezzanineCacheless</assetType>\n\t\t</target>\n\t</override>\n\t<override sourcePath=\"ftp://newa-fng-ngtv.ftp-library.sea1.theplatform.com/outbound\">\n\t\t<target>\n\t\t\t<path>fasp://aspera.soap.prod.theplatform.com:33001</path>\n\t\t\t<username>ngtv_outbound01</username>\n\t\t\t<password>k57wf6e9T9</password>\n\t\t\t<assetType>MezzanineCacheless</assetType>\n\t\t</target>\n\t</override>\n\t<override sourcePath=\"ftp://newa-fng-foxcom.ftp-library.sea1.theplatform.com/outbound\">\n\t\t<target>\n\t\t\t<path>fasp://aspera.soap.prod.theplatform.com:33001</path>\n\t\t\t<username>NEWA-FNG-FOXCOM_outbound_broadcasting</username>\n\t\t\t<password>yAyguf42g3</password>\n\t\t\t<assetType>MezzanineCacheless</assetType>\n\t\t</target>\n\t</override>\n\t\t<override sourcePath=\"ftp://newa-fng-foxsports-vod.ftp-library.sea1.theplatform.com/outbound\">\n\t\t<target>\n\t\t\t<path>fasp://aspera.soap.prod.theplatform.com:33001</path>\n\t\t\t<username>fsvod_outbound</username>\n\t\t\t<password>vt7qxdmTyg</password>\n\t\t\t<assetType>MezzanineCacheless</assetType>\n\t\t</target>\n\t</override>\n\t\t<override sourcePath=\"ftp://newa-fng-btn.ftp-library.sea1.theplatform.com/outbound\">\n\t\t<target>\n\t\t\t<path>fasp://aspera.soap.prod.theplatform.com:33001</path>\n\t\t\t<username>NEWA-FNG-BTN_outbound</username>\n\t\t\t<password>bUr9aea53z</password>\n\t\t\t<assetType>MezzanineCacheless</assetType>\n\t\t</target>\n\t</override>\n\t\t<override sourcePath=\"ftp://newa-fng-deportes.ftp-library.sea1.theplatform.com/outbound\">\n\t\t<target>\n\t\t\t<path>fasp://aspera.soap.prod.theplatform.com:33001</path>\n\t\t\t<username>deportes_outbound</username>\n\t\t\t<password>4za5heKux4</password>\n\t\t\t<assetType>MezzanineCacheless</assetType>\n\t\t</target>\n\t</override>\n</asperaOverrides>");
    }
}
