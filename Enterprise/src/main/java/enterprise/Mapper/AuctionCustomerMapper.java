package enterprise.Mapper;

import enterprise.Bean.Auction;

public interface AuctionCustomerMapper {
    Auction selectAuctionAndRecordList(int auctionid);
}
