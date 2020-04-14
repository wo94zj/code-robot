package ${pkgPath};

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 * 时间戳序列化时格式化为yyyy-MM-dd HH:mm:ss
 *
 */
public class LongFormatToDate implements ObjectSerializer {

	public static DateTimeFormatter COMMON_FORMAT = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").toFormatter();
	
	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			throws IOException {
		Long time = (Long) object;
		String format = TimeUtil.milliFormat(time, COMMON_FORMAT);
		serializer.write(format);
	}

}
