package com.ronny.smzdm.entity;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * @author Ronny
 * @date 2019-09-23.
 * description：
 */
public class ResultDataEntity {

    public enum SortRule {
        None,
        Time,
        Worthy,
        Collection
    }

    private static MainRecycleDataEntity.SortRule mSortRule = MainRecycleDataEntity.SortRule.Collection;

    public void setSortRule(MainRecycleDataEntity.SortRule sortRule) {
        mSortRule = sortRule;
    }

    private int article_total;
    private List<ArticleListBean> article_list;

    public int getArticle_total() {
        return article_total;
    }

    public void setArticle_total(int article_total) {
        this.article_total = article_total;
    }

    public List<ArticleListBean> getArticle_list() {
        return article_list;
    }

    public void setArticle_list(List<ArticleListBean> article_list) {
        this.article_list = article_list;
    }

    public static class ArticleListBean implements Comparable<MainRecycleDataEntity.ResultsBean> {
        @Override
        public int compareTo(@NonNull MainRecycleDataEntity.ResultsBean resultsBean) {
            if (mSortRule == MainRecycleDataEntity.SortRule.None) {
                return 0;
            } else if (mSortRule == MainRecycleDataEntity.SortRule.Time) {
                return resultsBean.getArticle_timesort() - this.article_timesort;
            } else if (mSortRule == MainRecycleDataEntity.SortRule.Worthy) {
                return resultsBean.getArticle_worthy() - Integer.parseInt(this.article_worthy);
            } else if (mSortRule == MainRecycleDataEntity.SortRule.Collection) {
                return resultsBean.getArticle_collection() - Integer.parseInt(this.article_collection);
            }
            return 0;
        }
        /**
         * article_id : 11599534
         * article_channel_id : 3
         * channel_id : 1
         * article_url : https://www.smzdm.com/p/11599534/
         * article_yh_type : youhui
         * article_title : 泉林本色 卷纸 三层 75节*12卷   *10件
         * article_price : 109元包邮（合10.9元/件）
         * article_date : 11-17 17:47
         * article_referrals : 小月尹口
         * article_user_url : https://zhiyou.smzdm.com/member/3463313749/
         * article_is_anonymous : 0
         * article_category : {"title":"卷纸","category_url":"https://www.smzdm.com/fenlei/juanzhi/"}
         * article_tags : [{"id":415884,"name":"日用品囤货","parent_id":null,"url_nicktitle":"","post_num":0,"fx_num":0,"os_num":0,"jy_num":0,"ht_num":0,"news_num":0,"all_num":90347,"tag_type":1,"image":"http://y.zdmimg.com/201706/12/593e7090a77232769.png","intro":"不要每次都等到家里的纸巾洗衣液用完了再高价买啦，常来看看，该囤则囤！","last_update_time":"2018-11-19 11:00:25","hj_num":0,"cw_num":0,"dw_num":0,"keyword":"日用品囤货","display":"日用品囤货","auditing_status":3,"source_from":0,"level":1,"smzdm_id":0,"bgm_id":0,"create_time":"2018-09-30 16:30:40","tiyou_time":"2018-10-08 01:09:28","bg_img":"http://y.zdmimg.com/201705/17/591c43fbde7dc6216.png","compage_share":"上 #什么值得买#， 关注《日用品囤货》，提升你的生活品质（分享自 @什么值得买）","top_data":"{\"article_url\":\"\",\"article_title\":\"\",\"article_channel\":\"\",\"article_id\":\"\",\"article_pic\":\"\"}","has_tab_haojia":0,"has_tab_faxian":0,"has_tab_duanwen":0,"show_haojia":0,"show_faxian":0,"show_duanwen":0,"allow_pub":0,"tag_url":"https://www.smzdm.com/tag/%E6%97%A5%E7%94%A8%E5%93%81%E5%9B%A4%E8%B4%A7/faxian/"}]
         * article_content : <strong>不漂白，环保健康~</strong>泉林本色 卷纸 三层75节*12卷，不漂白，无添加，采用天然秸秆本色原生浆，高温杀菌，亲肤不易破， 不掉纸屑，食品级，可以直接清洁、垫放食物。...
         * article_worthy : 8
         * article_unworthy : 18
         * article_collection : 16
         * article_comment : 16
         * article_link : https://go.smzdm.com/d144422fe4df89d9/ca_aa_yh_1515_11599534_10300_22013_1137_0
         * article_link_name :
         * article_link_nofollow : rel="nofollow"
         * article_link_arr : []
         * article_is_sold_out :
         * article_is_timeout :
         * article_mall : 京东
         * article_pic_url : https://qny.smzdm.com/201811/07/5be2a3dd70bfb206.png_d200.jpg
         * article_pic_style :  width="190px" height="190px" style="margin-top:0px"
         * article_mall_domain : jd.com
         * article_mall_link : https://www.smzdm.com/mall/jd/
         * article_timesort : 1542448054
         * article_taobao_url : {"is_taobao":false,"taobao_url":"https://go.smzdm.com/d144422fe4df89d9/ca_aa_yh_1515_11599534_10300_22013_1137_0","href":"https://go.smzdm.com/d144422fe4df89d9/ca_aa_yh_1515_11599534_10300_22013_1137_0"}
         * is_black_five : 0
         * article_title_mode : 0
         * gtm : {"id":"11599534","title":"泉林本色 卷纸 三层 75节*12卷   *10件","brand":"泉林本色","rmb_price":11,"mall":"京东","channel_dimension":"youhui","dimension4":"1阶价格","buy_domain":"jd.com","dimension20":"无","dimension12":"京东","dimension32":"先发后审","cates_str":"日用百货/家居清洁/纸品湿巾/卷纸","dimension25":"10300","dimension34":"","object":"{'name':'泉林本色 卷纸 三层 75节*12卷   *10件','id':'11599534' , 'price':'11','brand':'泉林本色' ,'mall':'京东', 'category':'日用百货/家居清洁/纸品湿巾/卷纸','metric1':'11','dimension10':'jd.com','dimension9':'youhui','dimension11':'1阶价格','dimension12':'京东','dimension20':'无','dimension32':'先发后审','dimension25':'10300'}"}
         * article_channel : 国内
         * article_button_name : 去购买
         * article_channel_url : https://www.smzdm.com/youhui/
         * article_channel_class : z-tag-guonei
         * mall_more_info : []
         * article_tese_tags : [{"id":415884,"name":"日用品囤货","parent_id":null,"url_nicktitle":"","post_num":0,"fx_num":0,"os_num":0,"jy_num":0,"ht_num":0,"news_num":0,"all_num":90347,"tag_type":1,"image":"http://y.zdmimg.com/201706/12/593e7090a77232769.png","intro":"不要每次都等到家里的纸巾洗衣液用完了再高价买啦，常来看看，该囤则囤！","last_update_time":"2018-11-19 11:00:25","hj_num":0,"cw_num":0,"dw_num":0,"keyword":"日用品囤货","display":"日用品囤货","auditing_status":3,"source_from":0,"level":1,"smzdm_id":0,"bgm_id":0,"create_time":"2018-09-30 16:30:40","tiyou_time":"2018-10-08 01:09:28","bg_img":"http://y.zdmimg.com/201705/17/591c43fbde7dc6216.png","compage_share":"上 #什么值得买#， 关注《日用品囤货》，提升你的生活品质（分享自 @什么值得买）","top_data":"{\"article_url\":\"\",\"article_title\":\"\",\"article_channel\":\"\",\"article_id\":\"\",\"article_pic\":\"\"}","has_tab_haojia":0,"has_tab_faxian":0,"has_tab_duanwen":0,"show_haojia":0,"show_faxian":0,"show_duanwen":0,"allow_pub":0,"tag_url":"https://www.smzdm.com/tag/%E6%97%A5%E7%94%A8%E5%93%81%E5%9B%A4%E8%B4%A7/faxian/"}]
         * atp : 3
         * tag_id : 无
         */

        private String article_id;
        private int article_channel_id;
        private String channel_id;
        private String article_url;
        private String article_yh_type;
        private String article_title;
        private String article_price;
        private String article_date;
        private String article_referrals;
        private String article_user_url;
        private String article_is_anonymous;
        private ArticleCategoryBean article_category;
        private String article_content;
        private String article_worthy;
        private String article_unworthy;
        private String article_collection;
        private String article_comment;
        private String article_link;
        private String article_link_name;
        private String article_link_nofollow;
        private String article_is_sold_out;
        private String article_is_timeout;
        private String article_mall;
        private String article_pic_url;
        private String article_pic_style;
        private String article_mall_domain;
        private String article_mall_link;
        private int article_timesort;
        private int is_black_five;
        private int article_title_mode;
        private String article_channel;
        private String article_button_name;
        private String article_channel_url;
        private String article_channel_class;
        private String atp;
        private String tag_id;
        private List<ArticleTagsBean> article_tags;
        private List<?> article_link_arr;
        private List<?> mall_more_info;
        private List<ArticleTeseTagsBean> article_tese_tags;

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public int getArticle_channel_id() {
            return article_channel_id;
        }

        public void setArticle_channel_id(int article_channel_id) {
            this.article_channel_id = article_channel_id;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public String getArticle_yh_type() {
            return article_yh_type;
        }

        public void setArticle_yh_type(String article_yh_type) {
            this.article_yh_type = article_yh_type;
        }

        public String getArticle_title() {
            return article_title;
        }

        public void setArticle_title(String article_title) {
            this.article_title = article_title;
        }

        public String getArticle_price() {
            return article_price;
        }

        public void setArticle_price(String article_price) {
            this.article_price = article_price;
        }

        public String getArticle_date() {
            return article_date;
        }

        public void setArticle_date(String article_date) {
            this.article_date = article_date;
        }

        public String getArticle_referrals() {
            return article_referrals;
        }

        public void setArticle_referrals(String article_referrals) {
            this.article_referrals = article_referrals;
        }

        public String getArticle_user_url() {
            return article_user_url;
        }

        public void setArticle_user_url(String article_user_url) {
            this.article_user_url = article_user_url;
        }

        public String getArticle_is_anonymous() {
            return article_is_anonymous;
        }

        public void setArticle_is_anonymous(String article_is_anonymous) {
            this.article_is_anonymous = article_is_anonymous;
        }

        public ArticleCategoryBean getArticle_category() {
            return article_category;
        }

        public void setArticle_category(ArticleCategoryBean article_category) {
            this.article_category = article_category;
        }

        public String getArticle_content() {
            return article_content;
        }

        public void setArticle_content(String article_content) {
            this.article_content = article_content;
        }

        public String getArticle_worthy() {
            return article_worthy;
        }

        public void setArticle_worthy(String article_worthy) {
            this.article_worthy = article_worthy;
        }

        public String getArticle_unworthy() {
            return article_unworthy;
        }

        public void setArticle_unworthy(String article_unworthy) {
            this.article_unworthy = article_unworthy;
        }

        public String getArticle_collection() {
            return article_collection;
        }

        public void setArticle_collection(String article_collection) {
            this.article_collection = article_collection;
        }

        public String getArticle_comment() {
            return article_comment;
        }

        public void setArticle_comment(String article_comment) {
            this.article_comment = article_comment;
        }

        public String getArticle_link() {
            return article_link;
        }

        public void setArticle_link(String article_link) {
            this.article_link = article_link;
        }

        public String getArticle_link_name() {
            return article_link_name;
        }

        public void setArticle_link_name(String article_link_name) {
            this.article_link_name = article_link_name;
        }

        public String getArticle_link_nofollow() {
            return article_link_nofollow;
        }

        public void setArticle_link_nofollow(String article_link_nofollow) {
            this.article_link_nofollow = article_link_nofollow;
        }

        public String getArticle_is_sold_out() {
            return article_is_sold_out;
        }

        public void setArticle_is_sold_out(String article_is_sold_out) {
            this.article_is_sold_out = article_is_sold_out;
        }

        public String getArticle_is_timeout() {
            return article_is_timeout;
        }

        public void setArticle_is_timeout(String article_is_timeout) {
            this.article_is_timeout = article_is_timeout;
        }

        public String getArticle_mall() {
            return article_mall;
        }

        public void setArticle_mall(String article_mall) {
            this.article_mall = article_mall;
        }

        public String getArticle_pic_url() {
            return article_pic_url;
        }

        public void setArticle_pic_url(String article_pic_url) {
            this.article_pic_url = article_pic_url;
        }

        public String getArticle_pic_style() {
            return article_pic_style;
        }

        public void setArticle_pic_style(String article_pic_style) {
            this.article_pic_style = article_pic_style;
        }

        public String getArticle_mall_domain() {
            return article_mall_domain;
        }

        public void setArticle_mall_domain(String article_mall_domain) {
            this.article_mall_domain = article_mall_domain;
        }

        public String getArticle_mall_link() {
            return article_mall_link;
        }

        public void setArticle_mall_link(String article_mall_link) {
            this.article_mall_link = article_mall_link;
        }

        public int getArticle_timesort() {
            return article_timesort;
        }

        public void setArticle_timesort(int article_timesort) {
            this.article_timesort = article_timesort;
        }

        public int getIs_black_five() {
            return is_black_five;
        }

        public void setIs_black_five(int is_black_five) {
            this.is_black_five = is_black_five;
        }

        public int getArticle_title_mode() {
            return article_title_mode;
        }

        public void setArticle_title_mode(int article_title_mode) {
            this.article_title_mode = article_title_mode;
        }

        public String getArticle_channel() {
            return article_channel;
        }

        public void setArticle_channel(String article_channel) {
            this.article_channel = article_channel;
        }

        public String getArticle_button_name() {
            return article_button_name;
        }

        public void setArticle_button_name(String article_button_name) {
            this.article_button_name = article_button_name;
        }

        public String getArticle_channel_url() {
            return article_channel_url;
        }

        public void setArticle_channel_url(String article_channel_url) {
            this.article_channel_url = article_channel_url;
        }

        public String getArticle_channel_class() {
            return article_channel_class;
        }

        public void setArticle_channel_class(String article_channel_class) {
            this.article_channel_class = article_channel_class;
        }

        public String getAtp() {
            return atp;
        }

        public void setAtp(String atp) {
            this.atp = atp;
        }

        public String getTag_id() {
            return tag_id;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

        public List<ArticleTagsBean> getArticle_tags() {
            return article_tags;
        }

        public void setArticle_tags(List<ArticleTagsBean> article_tags) {
            this.article_tags = article_tags;
        }

        public List<?> getArticle_link_arr() {
            return article_link_arr;
        }

        public void setArticle_link_arr(List<?> article_link_arr) {
            this.article_link_arr = article_link_arr;
        }

        public List<?> getMall_more_info() {
            return mall_more_info;
        }

        public void setMall_more_info(List<?> mall_more_info) {
            this.mall_more_info = mall_more_info;
        }

        public List<ArticleTeseTagsBean> getArticle_tese_tags() {
            return article_tese_tags;
        }

        public void setArticle_tese_tags(List<ArticleTeseTagsBean> article_tese_tags) {
            this.article_tese_tags = article_tese_tags;
        }

        public static class ArticleCategoryBean {
            /**
             * title : 卷纸
             * category_url : https://www.smzdm.com/fenlei/juanzhi/
             */

            private String title;
            private String category_url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCategory_url() {
                return category_url;
            }

            public void setCategory_url(String category_url) {
                this.category_url = category_url;
            }
        }

        public static class ArticleTagsBean {
            /**
             * id : 415884
             * name : 日用品囤货
             * parent_id : null
             * url_nicktitle :
             * post_num : 0
             * fx_num : 0
             * os_num : 0
             * jy_num : 0
             * ht_num : 0
             * news_num : 0
             * all_num : 90347
             * tag_type : 1
             * image : http://y.zdmimg.com/201706/12/593e7090a77232769.png
             * intro : 不要每次都等到家里的纸巾洗衣液用完了再高价买啦，常来看看，该囤则囤！
             * last_update_time : 2018-11-19 11:00:25
             * hj_num : 0
             * cw_num : 0
             * dw_num : 0
             * keyword : 日用品囤货
             * display : 日用品囤货
             * auditing_status : 3
             * source_from : 0
             * level : 1
             * smzdm_id : 0
             * bgm_id : 0
             * create_time : 2018-09-30 16:30:40
             * tiyou_time : 2018-10-08 01:09:28
             * bg_img : http://y.zdmimg.com/201705/17/591c43fbde7dc6216.png
             * compage_share : 上 #什么值得买#， 关注《日用品囤货》，提升你的生活品质（分享自 @什么值得买）
             * top_data : {"article_url":"","article_title":"","article_channel":"","article_id":"","article_pic":""}
             * has_tab_haojia : 0
             * has_tab_faxian : 0
             * has_tab_duanwen : 0
             * show_haojia : 0
             * show_faxian : 0
             * show_duanwen : 0
             * allow_pub : 0
             * tag_url : https://www.smzdm.com/tag/%E6%97%A5%E7%94%A8%E5%93%81%E5%9B%A4%E8%B4%A7/faxian/
             */

            private int id;
            private String name;
            private Object parent_id;
            private String url_nicktitle;
            private int post_num;
            private int fx_num;
            private int os_num;
            private int jy_num;
            private int ht_num;
            private int news_num;
            private int all_num;
            private int tag_type;
            private String image;
            private String intro;
            private String last_update_time;
            private int hj_num;
            private int cw_num;
            private int dw_num;
            private String keyword;
            private String display;
            private int auditing_status;
            private int source_from;
            private int level;
            private int smzdm_id;
            private int bgm_id;
            private String create_time;
            private String tiyou_time;
            private String bg_img;
            private String compage_share;
            private String top_data;
            private int has_tab_haojia;
            private int has_tab_faxian;
            private int has_tab_duanwen;
            private int show_haojia;
            private int show_faxian;
            private int show_duanwen;
            private int allow_pub;
            private String tag_url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getParent_id() {
                return parent_id;
            }

            public void setParent_id(Object parent_id) {
                this.parent_id = parent_id;
            }

            public String getUrl_nicktitle() {
                return url_nicktitle;
            }

            public void setUrl_nicktitle(String url_nicktitle) {
                this.url_nicktitle = url_nicktitle;
            }

            public int getPost_num() {
                return post_num;
            }

            public void setPost_num(int post_num) {
                this.post_num = post_num;
            }

            public int getFx_num() {
                return fx_num;
            }

            public void setFx_num(int fx_num) {
                this.fx_num = fx_num;
            }

            public int getOs_num() {
                return os_num;
            }

            public void setOs_num(int os_num) {
                this.os_num = os_num;
            }

            public int getJy_num() {
                return jy_num;
            }

            public void setJy_num(int jy_num) {
                this.jy_num = jy_num;
            }

            public int getHt_num() {
                return ht_num;
            }

            public void setHt_num(int ht_num) {
                this.ht_num = ht_num;
            }

            public int getNews_num() {
                return news_num;
            }

            public void setNews_num(int news_num) {
                this.news_num = news_num;
            }

            public int getAll_num() {
                return all_num;
            }

            public void setAll_num(int all_num) {
                this.all_num = all_num;
            }

            public int getTag_type() {
                return tag_type;
            }

            public void setTag_type(int tag_type) {
                this.tag_type = tag_type;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getLast_update_time() {
                return last_update_time;
            }

            public void setLast_update_time(String last_update_time) {
                this.last_update_time = last_update_time;
            }

            public int getHj_num() {
                return hj_num;
            }

            public void setHj_num(int hj_num) {
                this.hj_num = hj_num;
            }

            public int getCw_num() {
                return cw_num;
            }

            public void setCw_num(int cw_num) {
                this.cw_num = cw_num;
            }

            public int getDw_num() {
                return dw_num;
            }

            public void setDw_num(int dw_num) {
                this.dw_num = dw_num;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getDisplay() {
                return display;
            }

            public void setDisplay(String display) {
                this.display = display;
            }

            public int getAuditing_status() {
                return auditing_status;
            }

            public void setAuditing_status(int auditing_status) {
                this.auditing_status = auditing_status;
            }

            public int getSource_from() {
                return source_from;
            }

            public void setSource_from(int source_from) {
                this.source_from = source_from;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getSmzdm_id() {
                return smzdm_id;
            }

            public void setSmzdm_id(int smzdm_id) {
                this.smzdm_id = smzdm_id;
            }

            public int getBgm_id() {
                return bgm_id;
            }

            public void setBgm_id(int bgm_id) {
                this.bgm_id = bgm_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getTiyou_time() {
                return tiyou_time;
            }

            public void setTiyou_time(String tiyou_time) {
                this.tiyou_time = tiyou_time;
            }

            public String getBg_img() {
                return bg_img;
            }

            public void setBg_img(String bg_img) {
                this.bg_img = bg_img;
            }

            public String getCompage_share() {
                return compage_share;
            }

            public void setCompage_share(String compage_share) {
                this.compage_share = compage_share;
            }

            public String getTop_data() {
                return top_data;
            }

            public void setTop_data(String top_data) {
                this.top_data = top_data;
            }

            public int getHas_tab_haojia() {
                return has_tab_haojia;
            }

            public void setHas_tab_haojia(int has_tab_haojia) {
                this.has_tab_haojia = has_tab_haojia;
            }

            public int getHas_tab_faxian() {
                return has_tab_faxian;
            }

            public void setHas_tab_faxian(int has_tab_faxian) {
                this.has_tab_faxian = has_tab_faxian;
            }

            public int getHas_tab_duanwen() {
                return has_tab_duanwen;
            }

            public void setHas_tab_duanwen(int has_tab_duanwen) {
                this.has_tab_duanwen = has_tab_duanwen;
            }

            public int getShow_haojia() {
                return show_haojia;
            }

            public void setShow_haojia(int show_haojia) {
                this.show_haojia = show_haojia;
            }

            public int getShow_faxian() {
                return show_faxian;
            }

            public void setShow_faxian(int show_faxian) {
                this.show_faxian = show_faxian;
            }

            public int getShow_duanwen() {
                return show_duanwen;
            }

            public void setShow_duanwen(int show_duanwen) {
                this.show_duanwen = show_duanwen;
            }

            public int getAllow_pub() {
                return allow_pub;
            }

            public void setAllow_pub(int allow_pub) {
                this.allow_pub = allow_pub;
            }

            public String getTag_url() {
                return tag_url;
            }

            public void setTag_url(String tag_url) {
                this.tag_url = tag_url;
            }
        }

        public static class ArticleTeseTagsBean {
            /**
             * id : 415884
             * name : 日用品囤货
             * parent_id : null
             * url_nicktitle :
             * post_num : 0
             * fx_num : 0
             * os_num : 0
             * jy_num : 0
             * ht_num : 0
             * news_num : 0
             * all_num : 90347
             * tag_type : 1
             * image : http://y.zdmimg.com/201706/12/593e7090a77232769.png
             * intro : 不要每次都等到家里的纸巾洗衣液用完了再高价买啦，常来看看，该囤则囤！
             * last_update_time : 2018-11-19 11:00:25
             * hj_num : 0
             * cw_num : 0
             * dw_num : 0
             * keyword : 日用品囤货
             * display : 日用品囤货
             * auditing_status : 3
             * source_from : 0
             * level : 1
             * smzdm_id : 0
             * bgm_id : 0
             * create_time : 2018-09-30 16:30:40
             * tiyou_time : 2018-10-08 01:09:28
             * bg_img : http://y.zdmimg.com/201705/17/591c43fbde7dc6216.png
             * compage_share : 上 #什么值得买#， 关注《日用品囤货》，提升你的生活品质（分享自 @什么值得买）
             * top_data : {"article_url":"","article_title":"","article_channel":"","article_id":"","article_pic":""}
             * has_tab_haojia : 0
             * has_tab_faxian : 0
             * has_tab_duanwen : 0
             * show_haojia : 0
             * show_faxian : 0
             * show_duanwen : 0
             * allow_pub : 0
             * tag_url : https://www.smzdm.com/tag/%E6%97%A5%E7%94%A8%E5%93%81%E5%9B%A4%E8%B4%A7/faxian/
             */

            private int id;
            private String name;
            private Object parent_id;
            private String url_nicktitle;
            private int post_num;
            private int fx_num;
            private int os_num;
            private int jy_num;
            private int ht_num;
            private int news_num;
            private int all_num;
            private int tag_type;
            private String image;
            private String intro;
            private String last_update_time;
            private int hj_num;
            private int cw_num;
            private int dw_num;
            private String keyword;
            private String display;
            private int auditing_status;
            private int source_from;
            private int level;
            private int smzdm_id;
            private int bgm_id;
            private String create_time;
            private String tiyou_time;
            private String bg_img;
            private String compage_share;
            private String top_data;
            private int has_tab_haojia;
            private int has_tab_faxian;
            private int has_tab_duanwen;
            private int show_haojia;
            private int show_faxian;
            private int show_duanwen;
            private int allow_pub;
            private String tag_url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getParent_id() {
                return parent_id;
            }

            public void setParent_id(Object parent_id) {
                this.parent_id = parent_id;
            }

            public String getUrl_nicktitle() {
                return url_nicktitle;
            }

            public void setUrl_nicktitle(String url_nicktitle) {
                this.url_nicktitle = url_nicktitle;
            }

            public int getPost_num() {
                return post_num;
            }

            public void setPost_num(int post_num) {
                this.post_num = post_num;
            }

            public int getFx_num() {
                return fx_num;
            }

            public void setFx_num(int fx_num) {
                this.fx_num = fx_num;
            }

            public int getOs_num() {
                return os_num;
            }

            public void setOs_num(int os_num) {
                this.os_num = os_num;
            }

            public int getJy_num() {
                return jy_num;
            }

            public void setJy_num(int jy_num) {
                this.jy_num = jy_num;
            }

            public int getHt_num() {
                return ht_num;
            }

            public void setHt_num(int ht_num) {
                this.ht_num = ht_num;
            }

            public int getNews_num() {
                return news_num;
            }

            public void setNews_num(int news_num) {
                this.news_num = news_num;
            }

            public int getAll_num() {
                return all_num;
            }

            public void setAll_num(int all_num) {
                this.all_num = all_num;
            }

            public int getTag_type() {
                return tag_type;
            }

            public void setTag_type(int tag_type) {
                this.tag_type = tag_type;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getLast_update_time() {
                return last_update_time;
            }

            public void setLast_update_time(String last_update_time) {
                this.last_update_time = last_update_time;
            }

            public int getHj_num() {
                return hj_num;
            }

            public void setHj_num(int hj_num) {
                this.hj_num = hj_num;
            }

            public int getCw_num() {
                return cw_num;
            }

            public void setCw_num(int cw_num) {
                this.cw_num = cw_num;
            }

            public int getDw_num() {
                return dw_num;
            }

            public void setDw_num(int dw_num) {
                this.dw_num = dw_num;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getDisplay() {
                return display;
            }

            public void setDisplay(String display) {
                this.display = display;
            }

            public int getAuditing_status() {
                return auditing_status;
            }

            public void setAuditing_status(int auditing_status) {
                this.auditing_status = auditing_status;
            }

            public int getSource_from() {
                return source_from;
            }

            public void setSource_from(int source_from) {
                this.source_from = source_from;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getSmzdm_id() {
                return smzdm_id;
            }

            public void setSmzdm_id(int smzdm_id) {
                this.smzdm_id = smzdm_id;
            }

            public int getBgm_id() {
                return bgm_id;
            }

            public void setBgm_id(int bgm_id) {
                this.bgm_id = bgm_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getTiyou_time() {
                return tiyou_time;
            }

            public void setTiyou_time(String tiyou_time) {
                this.tiyou_time = tiyou_time;
            }

            public String getBg_img() {
                return bg_img;
            }

            public void setBg_img(String bg_img) {
                this.bg_img = bg_img;
            }

            public String getCompage_share() {
                return compage_share;
            }

            public void setCompage_share(String compage_share) {
                this.compage_share = compage_share;
            }

            public String getTop_data() {
                return top_data;
            }

            public void setTop_data(String top_data) {
                this.top_data = top_data;
            }

            public int getHas_tab_haojia() {
                return has_tab_haojia;
            }

            public void setHas_tab_haojia(int has_tab_haojia) {
                this.has_tab_haojia = has_tab_haojia;
            }

            public int getHas_tab_faxian() {
                return has_tab_faxian;
            }

            public void setHas_tab_faxian(int has_tab_faxian) {
                this.has_tab_faxian = has_tab_faxian;
            }

            public int getHas_tab_duanwen() {
                return has_tab_duanwen;
            }

            public void setHas_tab_duanwen(int has_tab_duanwen) {
                this.has_tab_duanwen = has_tab_duanwen;
            }

            public int getShow_haojia() {
                return show_haojia;
            }

            public void setShow_haojia(int show_haojia) {
                this.show_haojia = show_haojia;
            }

            public int getShow_faxian() {
                return show_faxian;
            }

            public void setShow_faxian(int show_faxian) {
                this.show_faxian = show_faxian;
            }

            public int getShow_duanwen() {
                return show_duanwen;
            }

            public void setShow_duanwen(int show_duanwen) {
                this.show_duanwen = show_duanwen;
            }

            public int getAllow_pub() {
                return allow_pub;
            }

            public void setAllow_pub(int allow_pub) {
                this.allow_pub = allow_pub;
            }

            public String getTag_url() {
                return tag_url;
            }

            public void setTag_url(String tag_url) {
                this.tag_url = tag_url;
            }
        }
    }
}

