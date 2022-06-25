package enterprise.Service.impl;

import enterprise.Bean.Auction;
import enterprise.Bean.AuctionExample;
import enterprise.Bean.Auctionrecord;
import enterprise.Mapper.AuctionCustomerMapper;
import enterprise.Mapper.AuctionMapper;
import enterprise.Mapper.AuctionrecordMapper;
import enterprise.Service.AuctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    @Resource
    private AuctionMapper auctionMapper;
    @Resource
    private AuctionCustomerMapper auctionCustomerMapper;
    @Resource
    private AuctionrecordMapper auctionrecordMapper;

    @Override
    public List<Auction> findAllAuctions(Auction auction) {
        /*创建竞拍品的条件查询类*/
        AuctionExample auctionExample = new AuctionExample();
        /*创建标准查询对象*/
        AuctionExample.Criteria criteria = auctionExample.createCriteria();
        /*先判断auction不为空才加条件*/
        if (auction != null) {
            /*判断竞拍品名称不为空且不等于空字符串*/
            if (!"".equals(auction.getAuctionname()) && auction.getAuctionname() != null) {
                /*加上条件*/
                criteria.andAuctionnameLike("%" + auction.getAuctionname() + "%");
            }
            /*判断竞拍品不为空*/
            if (!"".equals(auction.getAuctiondesc()) && auction.getAuctiondesc() != null) {
                /*创建sql加上 and auctiondesc like '%very%' */
                criteria.andAuctiondescLike("%" + auction.getAuctiondesc() + "%");
            }
            /*判断竞拍开始时间*/
            if (!"".equals(auction.getAuctionstarttime()) && auction.getAuctionstarttime() != null) {
                criteria.andAuctionstarttimeGreaterThanOrEqualTo(auction.getAuctionstarttime());
            }
            /*判断竞拍品结束时间*/
            if (!"".equals(auction.getAuctionendtime()) && auction.getAuctionendtime() != null) {
                criteria.andAuctionendtimeLessThanOrEqualTo(auction.getAuctionendtime());
            }
            /*判断竞拍*/
            if (auction.getAuctionstartprice() != null) {
                criteria.andAuctionstartpriceGreaterThanOrEqualTo(auction.getAuctionstartprice());
            }
        }
        return auctionMapper.selectByExample(auctionExample);
    }

    @Override
    public Auction selectAuctionAndRecordList(int auctionid) {
        Auction auction = auctionCustomerMapper.selectAuctionAndRecordList(auctionid);
        return auction;
    }


    /*1、检查有没有超过竞价时间
     * 2、有竞拍记录检查出价是否高于竞价记录里面的最高价
     * 3、没有竞拍记录出价必须高于竞拍品的底价*/
    @Override
    public void save(Auctionrecord auctionrecord) throws Exception {
        Auction auction = this.selectAuctionAndRecordList(auctionrecord.getAuctionid());
        /*判断有没有超过竞拍时间*/
        if (auctionrecord.getAuctiontime().after(auction.getAuctionendtime())) {
            throw new Exception("已超过竞拍时间");
        }

        /*没有竞拍记录*/
        if (auction.getAuctionrecodList().size() > 0) {
            /*检查出价是不是高于竞价记录里面的最高价*/
            Auctionrecord max = auction.getAuctionrecodList().get(0);
            if (auctionrecord.getAuctionprice().compareTo(max.getAuctionprice()) < 1) {
                throw new Exception("竞价不能低于最高价");

            }

        } else {
            if (auctionrecord.getAuctionprice().compareTo(auction.getAuctionstartprice()) < 1) {
                throw new Exception("竞价必须高于最底价");
            }
        }

        System.out.println("保存");

        auctionrecordMapper.insert(auctionrecord);

    }
}
