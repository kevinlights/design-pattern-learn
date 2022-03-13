package sample;

import dp.utils.XmlUtil;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Searcher searcher = (Searcher) Class.forName(XmlUtil.getL1Value("config.xml", "proxy")).newInstance();
        searcher.doSearch("admin", "test");
        System.out.println("============================");
        searcher.doSearch("test", "test");
    }
}

interface Searcher {
    String doSearch(String userId, String keyword);
}

class ProxySearcher implements Searcher {
    // 引用真实主题
    private RealSearcher searcher = new RealSearcher();
    // 引用验证对象
    private AccessValidator validator = new AccessValidator();
    private Logger logger = new Logger();

    @Override
    public String doSearch(String userId, String keyword) {
        if (validator.validate(userId)) {
            String result = searcher.doSearch(userId, keyword);
            logger.log(userId);
            return result;
        }
        return null;
    }


}

class RealSearcher implements Searcher {

    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println("用户'" + userId + "'使用关键词'" + keyword + "'查询商务信息！");
        return "result";
    }
}

class AccessValidator {
    public boolean validate(String userId) {
        System.out.println("在数据库中验证用户'" + userId + "'是否是合法用户？");
        if (userId.equals("admin")) {
            System.out.println(userId + " 登录成功");
            return true;
        } else {
            System.out.println(userId + " 登录失败");
            return false;
        }
    }
}

class Logger {
    public void log(String userId) {
        System.out.println("更新数据库，用户'" + userId + "'查询次数加1！");
    }
}
