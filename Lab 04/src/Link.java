public class Link {

    public long data; // data item
    public Link next; // next link in list

    public Link(long value) { // constructor
        data = value; // initialize data
        next = null;
    }

    public void displayLink() { // display ourself
        System.out.print("{" + data + "}-> ");
    }
}
