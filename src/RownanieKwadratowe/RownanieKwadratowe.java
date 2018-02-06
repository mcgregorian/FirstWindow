package RownanieKwadratowe;

public class RownanieKwadratowe {

    private double a,b,c;

    public RownanieKwadratowe(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public String solve(){

        String result="";
        double delta=b*b-4*a*c;
        if(delta>0)
        {
            String x11111="";
            String x22222="";
            double delta1=Math.sqrt(delta);
            double x1=(-b-delta1)/(2*a);
            double x2=(-b+delta1)/(2*a);
            //String x11=String.valueOf(x1);
            //if(x11.contains(".")) {
            //    String x111 = x11.substring(0, x11.indexOf("."));
            //    String x111d=x11.substring(x11.indexOf(".")+1,x11.length());
            //    String x1111=x111d.substring(0,3);
            //    x11111=x111+x1111;
            //}
            //else{
            //    x11111=x11;
            //}
            //String x22=String.valueOf(x2);
            //if(x22.contains(".")) {
            //  String x222 = x22.substring(0, x22.indexOf("."));
            //    String x222d=x22.substring(x22.indexOf(".")+1,x11.length());
            //    String x2222=x222d.substring(0,3);
            //    x22222=x222+x2222;
            //}
            //else{
            //    x22222=x22;
            //}

            result="Równanie ma 2 rozwiązania: "+x1+" oraz "+x2;
        }
        else if(delta==0)
        {
            String x11111="";
            double x1=(-b)/(2*a);
            //String x11=String.valueOf(x1);
            //if(x11.contains(".")) {
            //    String x111 = x11.substring(0, x11.indexOf("."));
            //    String x111d=x11.substring(x11.indexOf(".")+1,x11.length());
            //    String x1111=x111d.substring(0,3);
            //    x11111=x111+x1111;
            //}
            //else{
            //    x11111=x11;
            //}

            result="Równanie ma 1 rozwiązanie: "+x11111;
        }
        else if(delta<0)
        {
            result="Równanie nie ma rozwiązań.";
        }
        return result;
    }
    public void setA()
    {
        this.a=a;
    }
    public void setB()
    {
        this.b=b;
    }
    public void setC()
    {
        this.c=c;
    }
    public static void main(String args[]){
        RownanieKwadratowe rownanie=new RownanieKwadratowe(1,4,1);
        System.out.println(rownanie.solve());

    }
}
