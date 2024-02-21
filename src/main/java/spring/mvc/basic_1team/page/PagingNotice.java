package spring.mvc.basic_1team.page;

public class PagingNotice {

   private int pageSize = 10;   // 1page당 게시글의 갯수를 지정
   private int count = 0;      // 전체글의 갯수를 저장하는 변수
   private int number = 0;      // 페이지번호
   private String pageNum;
   
   private int startRow;      // 페이지별 시작번호
   private int endRow;         // 페이지별 끝번호
   
   private int currentPage;   // 현재페이지
   private int pageCount;
   private int startPage;
   private int pageBlock;
   private int endPage;
   
   private int prev;         // 이전
   private int next;         // 다음
   
   public PagingNotice() {}
   
   public PagingNotice(String pageNum) {
      
      // 맨처음 board_list.jsp를 클릭하거나, 수정 삭제 등 다른 게시글에서 페이지를 클릭할 때 pageNum이 없는 경우 null처리 
      if(pageNum == null) {
         pageNum = "1";
      }
      
      this.pageNum = pageNum;
      
      currentPage = Integer.parseInt(pageNum);
//      System.out.println("===============");
      
//      System.out.println("pageNum : " + pageNum);
//      System.out.println("currentPage : " + currentPage);
   }

   public int getPageSize() {
      return pageSize;
   }

   public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public String getPageNum() {
      return pageNum;
   }

   public void setPageNum(String pageNum) {
      this.pageNum = pageNum;
   }

   public int getStartRow() {
      return startRow;
   }

   public void setStartRow(int startRow) {
      this.startRow = startRow;
   }

   public int getEndRow() {
      return endRow;
   }

   public void setEndRow(int endRow) {
      this.endRow = endRow;
   }

   public int getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
   }

   public int getPageCount() {
      return pageCount;
   }

   public void setPageCount(int pageCount) {
      this.pageCount = pageCount;
   }

   public int getStartPage() {
      return startPage;
   }

   public void setStartPage(int startPage) {
      this.startPage = startPage;
   }

   public int getPageBlock() {
      return pageBlock;
   }

   public void setPageBlock(int pageBlock) {
      this.pageBlock = pageBlock;
   }

   public int getEndPage() {
      return endPage;
   }

   public void setEndPage(int endPage) {
      this.endPage = endPage;
   }

   public int getPrev() {
      return prev;
   }

   public void setPrev(int prev) {
      this.prev = prev;
   }

   public int getNext() {
      return next;
   }

   public void setNext(int next) {
      this.next = next;
   }
   
   public void setTotalCount(int count) {
      this.count = count;
      
      startRow = (currentPage - 1) * pageSize + 1;  // 페이지당 시작번호 => start
      endRow = currentPage * pageSize;   // 페이지당 끝번호 => end
      
      this.number = count - (currentPage - 1) * pageSize;   // 페이지번호
      
      // 페이지 계산
      pageCalculator();
   }
   
   public void pageCalculator() {
	    if(count > 0) {
	        pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
	        startPage = ((currentPage - 1) / 10) * 10 + 1; 
	        startPage = Math.max(startPage, 1); 
	        
	        // startPage가 1보다 작아지지 않도록 설정
	        // startPage 값이 1보다 작을 경우에는 값을 1로 설정 또는 항상 1 이상의 값을 유지
	        if (startPage < 1) {
	            startPage = 1; // Ensure startPage is never less than 1 
	        }
	        
	        pageBlock = 2;
	        endPage = startPage + pageBlock - 1;
	        
	        if(endPage > pageCount) endPage = pageCount;

	        // 이전
	        prev = startPage - 1;
	        prev = Math.max(prev, 1); 
	        
	        // 다음
	        next = startPage + 1;
	        
	        // next와 pageCount 중 작은 값 반환
	        // next가 pageCount보다 큰 경우에 next를 pageCount로 설정하여 유효한 범위 내에 있도록 설정
	        // next가 항상 페이지 수를 초과하지 않고 유효한 범위 내에 있도록 설정
	        next = Math.min(next, pageCount); 
	    }
	}
}