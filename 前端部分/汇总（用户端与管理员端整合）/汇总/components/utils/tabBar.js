// 普通用户tabbar
const tab1 = [
			{
				"text": "首页",
				"pagePath": "pages/index/index",
				"iconPath": "static/images/首页 (2).png",
				"selectedIconPath": "static/images/首页 (3).png"
			},
			{
				"text": "预约",
				"pagePath": "pages/order/order",
				"iconPath": "static/images/订单管理.png",
				"selectedIconPath": "static/images/订单管理(3).png"
			},
			{
				"text": "我的",
				"pagePath": "pages/user/user",
				"iconPath": "static/images/个人中心 (1).png",
				"selectedIconPath": "static/images/个人中心 (3).png"
			}
]
// 管理员用户tabbar
const tab2 = [
			{
				"text": "公告",
				"pagePath": "pages/adamin-gonggao/admin-gonggao",
				"iconPath": "/static/images/分类.png",
				"selectedIconPath": "/static/images/分类 (1).png"
			},
			{
				"text": "留言",
				"pagePath": "pages/admin-liuyan/admin-liuyan",
				"iconPath": "/static/images/订单管理.png",
				"selectedIconPath": "/static/images/订单管理 (1).png"
			},
			{
				"text": "用户",
				"pagePath": "pages/admin-heimingdan/admin-heimingdan",
				"iconPath": "/static/images/个人中心 (1).png",
				"selectedIconPath": "static/images/个人中心 (2).png"
			}
]
export default [
	tab1,
	tab2
]
