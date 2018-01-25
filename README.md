# Spring cron job based on quartz-jobs

## Create job

[POST] `/job`

### Param

| param | type | require | description |
| --- | :---: | :---: | --- |
| jobName | string | true | job name |
| jobGroupName | string | true | job group name |
| triggerName | string | true | trigger name |
| triggerGroupName | string | true | trigger group name |
| cron | string | true | cron expression |

### Sample

```
curl -X POST -H "Content-type: application/json" -d '{"jobName":"job_name","jobGroupName":"job_group_name","triggerName":"trigger_name","triggerGroupName":"trigger_group_name","cron":"0/3 * * * * ?"}' 'http://localhost:8080/job'
```

## Remove job

[DELETE] `/job`

### Param

| param | type | require | description |
| --- | :---: | :---: | --- |
| jobName | string | true | job name |
| jobGroupName | string | true | job group name |
| triggerName | string | true | trigger name |
| triggerGroupName | string | true | trigger group name |

### Sample

```
curl -X DELETE -H "Content-type: application/json" -d '{"jobName":"job_name","jobGroupName":"job_group_name","triggerName":"trigger_name","triggerGroupName":"trigger_group_name"}' 'http://localhost:8080/job'
```

## Start all job

[GET] `/job/start_all`

### Sample

```
curl 'http://localhost:8080/job/start_all'
```

## Shutdown all job

[GET] `/job/shutdown_all`

### Sample

```
curl 'http://localhost:8080/job/shutdown_all'
```