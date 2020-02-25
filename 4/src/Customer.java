

class Customer{
    long phNo;
    String id;
    Customer(long phNo, String id){
        this.phNo = phNo;
        this.id = id;
    }
    public String toString(){
        return "Phone Number: " + phNo +
                "\nid: " + id;
    }
    public long getPhNo() {
        return phNo;
    }
    public String getId() {
        return id;
    }
    public void setPhNo(long phNo) {
        this.phNo = phNo;
    }
    public void setId(String id) {
        this.id = id;
    }
}