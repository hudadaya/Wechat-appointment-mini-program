Page({
 
  /**
   * 页面的初始数据
   */
  data: {},
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this
    wx.request({
      url: 'http://8.134.201.230:8082/notice',//json数据地址
      headers: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        console.log(res),
        console.log(res.data.data)
        // console.log(res.data.imgListData[0].tag)
        //将获取到的json数据，存在名字叫list_data的这个数组中
        _this.setData({
          list_data: res.data.data,
          //res代表success函数的事件对，data是固定的，imgListData是上面json数据中imgListData
        })
      }
    })
  }
})