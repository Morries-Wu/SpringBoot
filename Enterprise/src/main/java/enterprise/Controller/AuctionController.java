package enterprise.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import enterprise.Bean.Auction;
import enterprise.Bean.Auctionrecord;
import enterprise.Bean.User;
import enterprise.Service.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Date;
import java.util.List;

@Controller
public class AuctionController {

    @Resource
    private AuctionService auctionService;

    /*分页显示数量*/
    public static final int pageSize = 5;

    /*注入AuctionService*/
   /* @RequestMapping("/queryAuctions")
    public String queryAuctions(Model model) {
        List<Auction> auctionList = auctionService.findAllAuctions(null);
        *//*把数据绑定到model中*//*
        model.addAttribute("auctionList", auctionList);

        return "auctionlist";
    }*/


    @RequestMapping("/queryAuctions")
    public String queryAuctions(@ModelAttribute("condition") Auction auction, Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Auction> auctionList = auctionService.findAllAuctions(auction);
        /*把数据绑定到model中*/
        model.addAttribute("auctionList", auctionList);
        PageInfo info = new PageInfo(auctionList);
        System.out.println("当前页码是:" + info.getPageNum());
        System.out.println("上一页:" + info.getPrePage());
        System.out.println("下一页:" + info.getNextPage());
        System.out.println("总页数:" + info.getPages());
        System.out.println("总记录数:" + info.getTotal());
        model.addAttribute("page", info);
        System.out.println("商品数量:" + auctionList.size());
        return "auctionlist";
    }

    @RequestMapping("/auctionDetail")
    public String auctionDetail(int auctionid, Model model) {
        Auction auctionDetail = auctionService.selectAuctionAndRecordList(auctionid);
        /*把数据放入model中*/
        model.addAttribute("auctionDetail", auctionDetail);
        return "auctionDetail";
    }

    /*保存竞拍记录*/
    @RequestMapping("/saveAuctionRecord")
    public String saveAuctionRecord(Auctionrecord auctionrecord, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        /*什么时间*/
        auctionrecord.setAuctiontime(new Date());
        /*保存*/
        auctionService.save(auctionrecord);
        /*跳转 重定向到原来竞拍详情*/
        return "redirect:/auctionDetail?auctionid="+auctionrecord.getAuctionid();
    }
}
