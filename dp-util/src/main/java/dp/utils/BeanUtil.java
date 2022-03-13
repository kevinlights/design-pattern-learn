package dp.utils;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class BeanUtil {
    /**
     * class modifier should be public
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static Object getBean(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(className).newInstance();
    }

    /**
     * class modifier should be public
     * @param resourceFile
     * @param l1Tag
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static Object getBeanFromXmlL1(String resourceFile, String l1Tag) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return getBean(XmlUtil.getL1Value(resourceFile, l1Tag));
    }
}
