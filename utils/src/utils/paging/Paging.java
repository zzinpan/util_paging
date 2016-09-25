package utils.paging;

public class Paging {
    private int pageSize; // �Խ� �� ��
    private int firstPageNo; // ù ��° ������ ��ȣ
    private int prevPageNo; // ���� ������ ��ȣ
    private int startPageNo; // ���� ������ (����¡ �׺� ����)
    private int pageNo; // ������ ��ȣ
    private int endPageNo; // �� ������ (����¡ �׺� ����)
    private int nextPageNo; // ���� ������ ��ȣ
	private int finalPageNo; // ������ ������ ��ȣ
    private int totalCount; // �Խ� �� ��ü ��
    private int pageNavSize; // ����¡ �׺� ǥ�� ��
    
    /**
     * @param page(������ ��ȣ)
     * @param pageSize(�Խ� �� ��)
     * @param pageNavSize(����¡ �׺� ǥ�� ��)
     * @param totalCnt(�Խ� �� ��ü ��)
     */
    public Paging(int page, int pageSize, int pageNavSize, int totalCnt) {
    	this.setPageNo(page);
        this.setPageSize(pageSize);
        this.setPageNavSize(pageNavSize);
        this.setTotalCount(totalCnt);
	}

	/**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the firstPageNo
     */
    public int getFirstPageNo() {
        return firstPageNo;
    }

    /**
     * @param firstPageNo the firstPageNo to set
     */
    public void setFirstPageNo(int firstPageNo) {
        this.firstPageNo = firstPageNo;
    }

    /**
     * @return the prevPageNo
     */
    public int getPrevPageNo() {
        return prevPageNo;
    }

    /**
     * @param prevPageNo the prevPageNo to set
     */
    public void setPrevPageNo(int prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    /**
     * @return the startPageNo
     */
    public int getStartPageNo() {
        return startPageNo;
    }

    /**
     * @param startPageNo the startPageNo to set
     */
    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the endPageNo
     */
    public int getEndPageNo() {
        return endPageNo;
    }

    /**
     * @param endPageNo the endPageNo to set
     */
    public void setEndPageNo(int endPageNo) {
        this.endPageNo = endPageNo;
    }

    /**
     * @return the nextPageNo
     */
    public int getNextPageNo() {
        return nextPageNo;
    }

    /**
     * @param nextPageNo the nextPageNo to set
     */
    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    /**
     * @return the finalPageNo
     */
    public int getFinalPageNo() {
        return finalPageNo;
    }

    /**
     * @param finalPageNo the finalPageNo to set
     */
    public void setFinalPageNo(int finalPageNo) {
        this.finalPageNo = finalPageNo;
    }

    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.makePaging();
    }

    /**
     * @return
     */
    public int getPageNavSize() {
		return pageNavSize;
	}

	/**
	 * @param pageNavSize
	 */
	public void setPageNavSize(int pageNavSize) {
		this.pageNavSize = pageNavSize;
	}

	/**
     * ����¡ ����
     */
    private void makePaging() {
        if (this.totalCount == 0) return; // �Խ� �� ��ü ���� ���� ���
        if (this.pageNo == 0) this.setPageNo(1); // �⺻ �� ����
        if (this.pageSize == 0) this.setPageSize(10); // �⺻ �� ����
        if (this.pageNavSize == 0) this.setPageNavSize(10); // �⺻ �� ����
        
        int finalPage = (totalCount + (pageSize - 1)) / pageSize; // ������ ������
        if (this.pageNo > finalPage) this.setPageNo(finalPage); // �⺻ �� ����

        if (this.pageNo < 0 || this.pageNo > finalPage) this.pageNo = 1; // ���� ������ ��ȿ�� üũ

        boolean isNowFirst = pageNo == 1 ? true : false; // ���� ������ (��ü)
        boolean isNowFinal = pageNo == finalPage ? true : false; // ������ ������ (��ü)

        int startPage = ((pageNo - 1) / this.pageNavSize) * this.pageNavSize + 1; // ���� ������ (����¡ �׺� ����)
        int endPage = startPage + this.pageNavSize - 1; // �� ������ (����¡ �׺� ����)

        if (endPage > finalPage) { // [������ ������ (����¡ �׺� ����) > ������ ������] ���� ū ���
            endPage = finalPage;
        }

        this.setFirstPageNo(1); // ù ��° ������ ��ȣ

        if (isNowFirst) {
            this.setPrevPageNo(1); // ���� ������ ��ȣ
        } else {
            this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); // ���� ������ ��ȣ
        }

        this.setStartPageNo(startPage); // ���� ������ (����¡ �׺� ����)
        this.setEndPageNo(endPage); // �� ������ (����¡ �׺� ����)

        if (isNowFinal) {
            this.setNextPageNo(finalPage); // ���� ������ ��ȣ
        } else {
            this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1))); // ���� ������ ��ȣ
        }

        this.setFinalPageNo(finalPage); // ������ ������ ��ȣ
    }
}
