//------------
// Notes
//	- To simplify building this example, both the ExtendedName
//		and Name class have been placed into this source file
//------------

class ExtendedName extends Name {
    public ExtendedName(String firstName, String 
                        middleName, String lastName) {
        super(firstName, lastName);
        this.middleName = middleName;
    }
    public ExtendedName(String firstName, 
                        String lastName) {
        super(firstName, lastName);
        this.middleName = "";
    }
    public String getMiddleInitial() {
        if (!middleName.equals(""))
           return middleName.substring(0, 1);
        else
           return "NMI";
    }
    public String getFormalName() {
        return title + " " + firstName + " " + middleName 
                     + " " + lastName;
    }
    public static void main(String [] args) {
        ExtendedName en = new ExtendedName("Anna", 
                                       "Louise", "Strong");
        System.out.println(en.getMiddleInitial());
        System.out.println(en.getFormalName());
        System.out.println(en.getLastFirst());
        en = new ExtendedName("Gerald", "Weiss");
        System.out.println(en.getMiddleInitial());
        System.out.println(en.getFormalName());
        System.out.println(en.getLastFirst()); 
	}
    private String middleName;
}

class Name{
    public Name(String first, String last){
        firstName = first;
        lastName = last;
        title = "";
    }
    public String getInitials(){
        String s;
        s = firstName.substring(0,1);
        s = s.concat(".");
        s = s.concat(lastName.substring(0,1));
        s = s.concat(".");
        return s;
    }
    public String getLastFirst(){
        return lastName.concat(",").concat(firstName);
    }
    public String getFirstLast(){
        return title.concat("").
                   concat(firstName).
                       concat("").concat(lastName);
    }
    public void setTitle(String newTitle){
        title = newTitle;
    }
    protected String firstName; 
    protected String lastName;
    protected String title;
}

