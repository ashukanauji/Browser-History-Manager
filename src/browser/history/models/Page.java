package browser.history.models;

public class Page {
    private String url;
    private Page previous;
    private Page next;

    public Page(String url) {
        this.url = url;
        this.previous = null;
        this.next = null;
    }

    public String getUrl() {
        return url;
    }

    public Page getPrevious() {
        return previous;
    }

    public void setPrevious(Page previous) {
        this.previous = previous;
    }

    public Page getNext() {
        return next;
    }

    public void setNext(Page next) {
        this.next = next;
    }
}
