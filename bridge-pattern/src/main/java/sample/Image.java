package sample;

import dp.utils.XmlUtil;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Image image = (Image) Class.forName(XmlUtil.getL1Value("config.xml", "image")).newInstance();
        ImageImpl impl = (ImageImpl) Class.forName(XmlUtil.getL1Value("config.xml", "os")).newInstance();

        image.setImpl(impl);
        image.parseFile("text");
    }
}

public abstract class Image {
    protected ImageImpl impl;

    public void setImpl(ImageImpl impl) {
        this.impl = impl;
    }

    public abstract void parseFile(String fileNam);
}

interface ImageImpl {
    public void doPaint(Matrix m);
}

class JPGImage extends Image {

    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}

class PNGImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析PNG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为PNG。");
    }
}

class BMPImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为BMP。");
    }
}

class GIFImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析GIF文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为GIF。");
    }
}


class WindowsImpl implements ImageImpl {
    public void doPaint(Matrix m) {
        //调用Windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows操作系统中显示图像：");
    }
}

class UnixImpl implements ImageImpl {
    public void doPaint(Matrix m) {
        //调用Unix系统的绘制函数绘制像素矩阵
        System.out.print("在Unix操作系统中显示图像：");
    }
}


class LinuxImpl implements ImageImpl {
    public void doPaint(Matrix m) {
        //调用Linux系统的绘制函数绘制像素矩阵
        System.out.print("在Linux操作系统中显示图像：");
    }
}

class Matrix {
}