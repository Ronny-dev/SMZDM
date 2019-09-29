package com.ronny.smzdm.entity;

import androidx.annotation.NonNull;

import java.util.List;

public class MainRecycleDataEntity{

    public enum SortRule {
        None,
        Time,
        Worthy,
        Collection
    }

    private static SortRule mSortRule = SortRule.None;

    public void setSortRule(SortRule sortRule) {
        mSortRule = sortRule;
    }

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Comparable<ResultsBean>{
        @Override
        public int compareTo(@NonNull ResultsBean resultsBean) {
            if (mSortRule == SortRule.None) {
                return 0;
            } else if (mSortRule == SortRule.Time) {
                return resultsBean.article_timesort - this.article_timesort;
            } else if (mSortRule == SortRule.Worthy) {
                return resultsBean.article_worthy - this.article_worthy;
            } else if (mSortRule == SortRule.Collection) {
                return resultsBean.article_collection - this.article_collection;
            }
            return 0;
        }

        /**
         * article_collection : 27
         * article_comment : 36
         * article_date : 09:50
         * article_id : 11646156
         * article_link : https://go.smzdm.com/fdf246cd3b5d0333/ca_aa_yh_163_11646156_10991_1683_179_0
         * article_mall : 京东
         * article_pic_style :  width="190px" height="190px" style="margin-top:0px"
         * article_pic_url : https://y.zdmimg.com/201805/21/5b0239c12dcff711.jpg_d200.jpg
         * article_price : 7988元包邮（满减）
         * article_timesort : 1542765007
         * article_title : 16点开始： Hasee 神舟 精盾T97E 15.6英寸游戏笔记本电脑（i7-8750H、8GB、256GB、GTX1070Max-Q 8GB）
         * article_unworthy : 4
         * article_url : https://www.smzdm.com/p/11646156/
         * article_worthy : 38
         * createdAt : 2018-11-21 10:21:02
         * objectId : bf26a9d9be
         * updatedAt : 2018-11-21 10:21:02
         */

        private int article_collection;
        private int article_comment;
        private String article_date;
        private String article_id;
        private String article_link;
        private String article_mall;
        private String article_pic_style;
        private String article_pic_url;
        private String article_price;
        private int article_timesort;
        private String article_title;
        private int article_unworthy;
        private String article_url;
        private int article_worthy;
        private String createdAt;
        private String objectId;
        private String updatedAt;

        public int getArticle_collection() {
            return article_collection;
        }

        public void setArticle_collection(int article_collection) {
            this.article_collection = article_collection;
        }

        public int getArticle_comment() {
            return article_comment;
        }

        public void setArticle_comment(int article_comment) {
            this.article_comment = article_comment;
        }

        public String getArticle_date() {
            return article_date;
        }

        public void setArticle_date(String article_date) {
            this.article_date = article_date;
        }

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public String getArticle_link() {
            return article_link;
        }

        public void setArticle_link(String article_link) {
            this.article_link = article_link;
        }

        public String getArticle_mall() {
            return article_mall;
        }

        public void setArticle_mall(String article_mall) {
            this.article_mall = article_mall;
        }

        public String getArticle_pic_style() {
            return article_pic_style;
        }

        public void setArticle_pic_style(String article_pic_style) {
            this.article_pic_style = article_pic_style;
        }

        public String getArticle_pic_url() {
            return article_pic_url;
        }

        public void setArticle_pic_url(String article_pic_url) {
            this.article_pic_url = article_pic_url;
        }

        public String getArticle_price() {
            return article_price;
        }

        public void setArticle_price(String article_price) {
            this.article_price = article_price;
        }

        public int getArticle_timesort() {
            return article_timesort;
        }

        public void setArticle_timesort(int article_timesort) {
            this.article_timesort = article_timesort;
        }

        public String getArticle_title() {
            return article_title;
        }

        public void setArticle_title(String article_title) {
            this.article_title = article_title;
        }

        public int getArticle_unworthy() {
            return article_unworthy;
        }

        public void setArticle_unworthy(int article_unworthy) {
            this.article_unworthy = article_unworthy;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public int getArticle_worthy() {
            return article_worthy;
        }

        public void setArticle_worthy(int article_worthy) {
            this.article_worthy = article_worthy;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
}
