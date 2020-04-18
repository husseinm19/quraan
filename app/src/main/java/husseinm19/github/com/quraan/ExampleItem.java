package husseinm19.github.com.quraan;

/**
 * Created by hussein on 14/04/2020.
 */

public class ExampleItem {
    private String mText1;
    private String mText2;
    private String Mpdf;

    public ExampleItem( String text1, String text2 ,String pdf2) {

        mText1 = text1;
        mText2 = text2;
        Mpdf =  pdf2;
    }



    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public String  getpdf() {
        return Mpdf;
    }


}
