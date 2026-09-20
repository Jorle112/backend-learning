public class Book {
    private String title;
    private double price;

    public Book(String title,double price){
        this.title = title;
        this.price = price; 
    }
    public void a(){
        System.out.println(title+price+"元");
    }

    public static void main(String[] args){
        Book b = new Book("java入门",12);
        b.a(); 
    }
}
