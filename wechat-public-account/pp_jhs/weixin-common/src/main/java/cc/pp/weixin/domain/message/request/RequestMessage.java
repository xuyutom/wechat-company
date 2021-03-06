package cc.pp.weixin.domain.message.request;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import cc.pp.weixin.constant.MsgFieldName;
import cc.pp.weixin.domain.message.BaseMessage;


/**
 * 微信公众平台请求消息父类
 * @author wgybzb
 * @since  2013-04-06
 */
public class RequestMessage extends BaseMessage {
	/**
	 * 默认的序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 消息id，64位整型
	 */
	protected long msgId;
	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	/**
	 * 默认构造函数
	 */
	public RequestMessage() {

	}

	/**
	 * 构造函数：根据微信平台的请求数据，封装请求消息通用属性
	 */
	public RequestMessage(Element element) {
		//调用父类的构造方法，初始化通用信息
		super(element);

		if (element == null){
			return;
		}
		String msgId = element.elementText(MsgFieldName.MSG_ID);
		if (StringUtils.isNotEmpty(msgId)){
			this.msgId = Long.valueOf(msgId);
		}
	}
}
