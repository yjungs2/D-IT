package servlet.model;

public class ProductVO {
	private String name;
	private String price;
	private String expl;
	//private int seq;
	
	public ProductVO(String name, String price, String expl) {
		super();
		this.name = name;
		this.price = price;
		this.expl = expl;
	}
	public ProductVO() { }
//	public ProductVO(int seq, String name, String price, String expl) {
//		super();
//		this.seq = seq;
//		this.name = name;
//		this.price = price;
//		this.expl = expl;
//	}
//	
//	public int getSeq() {
//		return seq;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getExpl() {
		return expl;
	}
	public void setExpl(String expl) {
		this.expl = expl;
	}
	
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", expl=" + expl + "]";
	}
}