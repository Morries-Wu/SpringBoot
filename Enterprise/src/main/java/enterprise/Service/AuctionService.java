package enterprise.Service;

import enterprise.Bean.Auction;
import enterprise.Bean.Auctionrecord;

import java.util.List;

public interface AuctionService {
    List<Auction> findAllAuctions(Auction auction);

    Auction selectAuctionAndRecordList(int auctionid);

    void save(Auctionrecord auctionrecord) throws Exception;
}
