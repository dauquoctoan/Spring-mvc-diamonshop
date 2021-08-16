package DiamonShops.UserService;

import org.springframework.stereotype.Service;

import DiamonShops.Dto.PaginatesDto;

@Service
public class PaginatesServiceImpl implements IPaginatesService{
	public PaginatesDto getInforPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginate = new PaginatesDto();
		paginate.setLimit(limit);
		paginate.setTotalPage(SetInfoTotalPage(totalData, limit));
		paginate.setCurrentPage(CheckCurrentPage(currentPage ,paginate.getTotalPage()));
		int start = FindStart(paginate.getCurrentPage(), limit);
		paginate.setStart(start);
		int end = FindEnd(paginate.getStart(), limit, totalData);
		paginate.setEnd(end);
		return paginate;
	}

	private int FindEnd(int start, int limit, int totalData) {
		if((start + limit) > totalData) {
			return totalData;
		}
		return start + limit;
	}

	private int FindStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit);
	}

	private int SetInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		if((totalPage * limit )< totalData) {
			totalPage = totalPage + 1;
		}
//		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	public int CheckCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
