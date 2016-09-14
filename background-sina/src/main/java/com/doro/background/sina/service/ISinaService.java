package com.doro.background.sina.service;

import com.doro.background.sina.entity.BindingBankCard;
import com.doro.background.sina.entity.BindingBankCardAdvance;
import com.doro.background.sina.entity.BindingVerify;
import com.doro.background.sina.entity.CreateActivateMember;
import com.doro.background.sina.entity.CreateHostingCollectTrade;
import com.doro.background.sina.entity.CreateHostingDeposit;
import com.doro.background.sina.entity.CreateHostingWithdraw;
import com.doro.background.sina.entity.CreateSingleHostingPayTrade;
import com.doro.background.sina.entity.QueryBalance;
import com.doro.background.sina.entity.QueryHostingDeposit;
import com.doro.background.sina.entity.QueryHostingTrade;
import com.doro.background.sina.entity.QueryHostingWithdraw;
import com.doro.background.sina.entity.QueryIsSetPayPassword;
import com.doro.background.sina.entity.QueryMiddleAccount;
import com.doro.background.sina.entity.SetPayPassword;
import com.doro.background.sina.entity.SetRealName;
import com.doro.background.sina.entity.ShowMemberInfosSina;
import com.doro.background.sina.entity.returns.BindingBankCardAdvanceReturnMsg;
import com.doro.background.sina.entity.returns.BindingBankCardReturnMsg;
import com.doro.background.sina.entity.returns.CreateHostingDepositReturnMsg;
import com.doro.background.sina.entity.returns.CreateHostingWithdrawReturnMsg;
import com.doro.background.sina.entity.returns.CreateSingleHostingPayTradeReturnMsg;
import com.doro.background.sina.entity.returns.QueryBalanceReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingDepositReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingTradeReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingWithdrawReturnMsg;
import com.doro.background.sina.entity.returns.QueryIsSetPayPasswordReturnMsg;
import com.doro.background.sina.entity.returns.QueryMiddleAccountReturnMsg;
import com.doro.background.sina.entity.returns.QueryTradeReturnMsg;
import com.doro.background.sina.entity.returns.ReturnMsg;
import com.doro.background.sina.entity.returns.SetPayPasswordReturnMsg;
import com.doro.background.sina.entity.returns.ShowMemberInfosSinaReturnMsg;

public interface ISinaService {
	/**
	 * 创建激活会员
	 * @param createActivateMember
	 * @return
	 */
	public ReturnMsg createActivateMember(CreateActivateMember createActivateMember);
	
	/**
	 * 设置实名信息
	 * @param setRealName
	 * @return
	 */
	public ReturnMsg setRealName(SetRealName setRealName);
	
	/**
	 * 绑定认证信息
	 * @param bindingVerify
	 * @return
	 */
	public ReturnMsg bindingVerify(BindingVerify bindingVerify);
	
	/**
	 * 绑定银行卡
	 * @param bandingBankCard
	 * @return
	 */
	public BindingBankCardReturnMsg bindingBankCard(BindingBankCard bandingBankCard);
	
	
	/**
	 * 绑定银行卡推进
	 * @param bankCardAdvance
	 * @return
	 */
	public BindingBankCardAdvanceReturnMsg bindingBankCardAdvance(BindingBankCardAdvance bankCardAdvance);
	
	/**
	 * 充值参数封装
	 * @param createHostingDeposit
	 * @return
	 */
	public String createHostionDeposit(CreateHostingDeposit createHostingDeposit);
	
	/**
	 * 体现参数封装
	 * @param createHostingWithdraw
	 * @return
	 */
	public String createHostionWithdraw(CreateHostingWithdraw createHostingWithdraw);
	
	/**
	 * 代付参数封装
	 * @param createSingleHostingPayTrade
	 * @return
	 */
	public CreateSingleHostingPayTradeReturnMsg createSingleHostingPayTrade(CreateSingleHostingPayTrade createSingleHostingPayTrade);
	
	/**
	 * 代收参数封装
	 * @param collectTrade
	 * @return
	 */
	public String createHostingCollectTrade(CreateHostingCollectTrade collectTrade);
	/**
	 * 代收异步回调验证
	 * @param msg
	 * @return
	 */
	public boolean collectTradenotifyUrlDecrypt(QueryTradeReturnMsg msg);
	
	/**
	 * 设置新浪交易密码页面
	 * @param setPayPassword
	 * @return
	 */
	public SetPayPasswordReturnMsg setPayPassword(SetPayPassword setPayPassword);
	
	/**
	 * 2.17	sina页面展示用户信息
	 * @param showMemberInfosSina
	 * @return
	 */
	public ShowMemberInfosSinaReturnMsg showMemberInfosSina(ShowMemberInfosSina showMemberInfosSina);
	
	/**
	 * 查询是否设置支付密码
	 * @param queryIsSetPayPassword
	 * @return
	 */
	public QueryIsSetPayPasswordReturnMsg queryIsSetPayPassword(QueryIsSetPayPassword queryIsSetPayPassword);
	
	/**
	 * 充值异步回调
	 * @param msg
	 * @return
	 */
	public boolean DenotifyUrlDecrypt(CreateHostingDepositReturnMsg msg);
	
	/**
	 * 查询充值订单
	 * @param queryHostingDeposit
	 * @return
	 */
	public QueryHostingDepositReturnMsg queryHostingDeposit(QueryHostingDeposit queryHostingDeposit);
	
	/**
	 * 体现异步回调
	 * @param msg
	 * @return
	 */
	public boolean withdrawnotifyUrlDecrypt(CreateHostingWithdrawReturnMsg msg);
	
	/**
	 * 查询体现订单
	 * @param queryHostingDeposit
	 * @return
	 */
	public QueryHostingWithdrawReturnMsg queryHostingWithdraw(QueryHostingWithdraw queryHostingWithdraw);
	/**
	 * 订单交易查询
	 * @param queryHostingTrade
	 * @return
	 */
	public QueryHostingTradeReturnMsg queryHostingTrade(QueryHostingTrade queryHostingTrade);
	
	/**
	 * 查询用户新浪余额
	 * @param queryBalance
	 * @return
	 */
	public QueryBalanceReturnMsg queryBalance(QueryBalance queryBalance);
	
	/**
	 * 查询中间账户
	 * @param queryMiddleAccount
	 * @return
	 */
	public QueryMiddleAccountReturnMsg queryMiddleAccountReturnMsg(QueryMiddleAccount queryMiddleAccount);
}
