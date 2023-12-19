<template>
  <div class="container">
    <h1>留言板</h1>
    <div v-for="(message, index) in messages" :key="index" class="message">
      <p>{{ message.text }}</p>
      <p class="date">{{ message.date }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      messages: [
        { text: '研讨室302桌子怎么是坏的', date: '2023-12-07' },
        { text: '教学楼102的空调开不了', date: '2023-12-01' },
        { text: '捡到校园卡', date: '2023-11-05' },
        // 可根据需要添加更多留言
      ],
    };
  },
};
</script>

<style>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
  color: #333; /* 用于留言文本的颜色 */
}

h1 {
  text-align: center;
  color: #83c6c2; /* 页面主题色调 */
  margin-bottom: 20px; /* 留白间距 */
}

.message {
  border-bottom: 1px solid #eee; /* 分隔留言的边框线 */
  padding-bottom: 10px;
  margin-bottom: 20px;
}

.date {
  text-align: right;
  color: #999; /* 日期的颜色 */
}
</style>
