# interview
获取用户集合
get请求：localhost:8088/interview/user/users
返回：[
{
"id": 1,
"loginname": "andy",
"password": null,
"name": "Andy"
},
{
"id": 2,
"loginname": "carl",
"password": null,
"name": "Carl"
},
{
"id": 3,
"loginname": "bruce",
"password": null,
"name": "Bruce"
},
{
"id": 4,
"loginname": "dolly",
"password": null,
"name": "Dolly"
}
]

添加用户
post请求：localhost:8088/interview/user/users


通过id获取用户信息
get请求： localhost:8088/interview/user/users/1

更新用户
put请求： localhost:8088/interview/user/users/1
参数：{
"id": 222,
"loginname": "carl222",
"password": null,
"name": "Carl222"
}

删除用户
delete请求：localhost:8088/interview/user/users/1

通过登录名“a”获取用户信息，支持模糊查询
get请求： localhost:8088/interview/user/users/loginname/a
返回：[
{
"id": 1,
"loginname": "andy",
"password": null,
"name": "Andy"
},
{
"id": 2,
"loginname": "carl",
"password": null,
"name": "Carl"
}
]
