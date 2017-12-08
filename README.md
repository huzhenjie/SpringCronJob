# 基于Spring的定时任务

## 创建任务

[POST] `/job`

### Param

| param | type | require | description |
| --- | :---: | :---: | --- |
| jobName | string | true | 任务名称 |
| jobGroupName | string | true | 任务分组名称 |
| triggerName | string | true | 触发器名称 |
| triggerGroupName | string | true | 触发器分组名称 |
| cron | string | true | cron表达式 |

### Sample

```
curl -X POST -H "Content-type: application/json" -d '{"jobName":"job_name","jobGroupName":"job_group_name","triggerName":"trigger_name","triggerGroupName":"trigger_group_name","cron":"0/3 * * * * ?"}' 'http://localhost:8080/job'
```

## 移除任务

[DELETE] `/job`

### Param

| param | type | require | description |
| --- | :---: | :---: | --- |
| jobName | string | true | 任务名称 |
| jobGroupName | string | true | 任务分组名称 |
| triggerName | string | true | 触发器名称 |
| triggerGroupName | string | true | 触发器分组名称 |

### Sample

```
curl -X DELETE -H "Content-type: application/json" -d '{"jobName":"job_name","jobGroupName":"job_group_name","triggerName":"trigger_name","triggerGroupName":"trigger_group_name"}' 'http://localhost:8080/job'
```

## 开启所有任务

[GET] `/job/start_all`

### Sample

```
curl 'http://localhost:8080/job/start_all'
```

## 关闭所有任务

[GET] `/job/shutdown_all`

### Sample

```
curl 'http://localhost:8080/job/shutdown_all'
```