package ohtu;

public class Submission {
    private String student_number;
    private int maximi;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    
    public void setMaximi(int maximi) {
        this.maximi = maximi;
    }
    
    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }

    public void setA12(boolean a12) {
        this.a12 = a12;
    }

    public void setA13(boolean a13) {
        this.a13 = a13;
    }

    public void setA14(boolean a14) {
        this.a14 = a14;
    }

    public void setA15(boolean a15) {
        this.a15 = a15;
    }

    public void setA16(boolean a16) {
        this.a16 = a16;
    }

    public void setA17(boolean a17) {
        this.a17 = a17;
    }

    public void setA18(boolean a18) {
        this.a18 = a18;
    }

    public void setA19(boolean a19) {
        this.a19 = a19;
    }

    public void setA20(boolean a20) {
        this.a20 = a20;
    }

    public void setA21(boolean a21) {
        this.a21 = a21;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getMaximi() {
        return maximi;
    }
    
    public int getTotal() {
        int total = 0;
        
        if(a1) total++;
        if(a2) total++;
        if(a3) total++;
        if(a4) total++;
        if(a5) total++;
        if(a6) total++;
        if(a7) total++;
        if(a8) total++;
        if(a9) total++;
        if(a10) total++;
        if(a11) total++;
        if(a12) total++;
        if(a13) total++;
        if(a14) total++;
        if(a15) total++;
        if(a16) total++;
        if(a17) total++;
        if(a18) total++;
        if(a19) total++;
        if(a20) total++;
        if(a21) total++;
        
        return total;
    }

    public int getWeek() {
        return week;
    }

    public int getHours() {
        return hours;
    }

    public boolean isA1() {
        return a1;
    }

    public boolean isA2() {
        return a2;
    }

    public boolean isA3() {
        return a3;
    }

    public boolean isA4() {
        return a4;
    }

    public boolean isA5() {
        return a5;
    }

    public boolean isA6() {
        return a6;
    }

    public boolean isA7() {
        return a7;
    }

    public boolean isA8() {
        return a8;
    }

    public boolean isA9() {
        return a9;
    }

    public boolean isA10() {
        return a10;
    }

    public boolean isA11() {
        return a11;
    }

    public boolean isA12() {
        return a12;
    }

    public boolean isA13() {
        return a13;
    }

    public boolean isA14() {
        return a14;
    }

    public boolean isA15() {
        return a15;
    }

    public boolean isA16() {
        return a16;
    }

    public boolean isA17() {
        return a17;
    }

    public boolean isA18() {
        return a18;
    }

    public boolean isA19() {
        return a19;
    }

    public boolean isA20() {
        return a20;
    }

    public boolean isA21() {
        return a21;
    }    

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if(a1) sb.append("1 ");
        if(a2) sb.append("2 ");
        if(a3) sb.append("3 ");
        if(a4) sb.append("4 ");
        if(a5) sb.append("5 ");
        if(a6) sb.append("6 ");
        if(a7) sb.append("7 ");
        if(a8) sb.append("8 ");
        if(a9) sb.append("9 ");
        if(a10) sb.append("10 ");
        if(a11) sb.append("11 ");
        if(a12) sb.append("12 ");
        if(a13) sb.append("13 ");
        if(a14) sb.append("14 ");
        if(a15) sb.append("15 ");
        if(a16) sb.append("16 ");
        if(a17) sb.append("17 ");
        if(a18) sb.append("18 ");
        if(a19) sb.append("19 ");
        if(a20) sb.append("20 ");
        if(a21) sb.append("21 ");
        
        return "viikko " + this.week + ": "
                + "tehtyjä tehtäviä yhteensä: " + this.getTotal() + " "
                + "(maksimi " + this.maximi + "), "
                + "aikaa kului " + this.hours + " tuntia, "
                + "tehdyt tehtävät: " + sb.toString();
    }
    
}
