package sample.application;

import org.osgi.service.component.annotations.Component;

    @Component(immediate = true, service = FileDataHandler.class)
    public class FileDataHandlerServiceImpl extends FileDataHandler {

        public FileDataHandlerServiceImpl() {
            super("C:\\Users\\Amal2\\Documents\\TestApi"); // تأكد من أن المسار هنا صحيح ويشير إلى المجلد الذي يحتوي على الملفات
        }
}


