<template>
  <div>
    <gantt-elastic :options="options" :tasks="dataSource" :dynamic-style="dynamicStyle">
      @tasks-changed="tasksUpdate"
      @options-changed="optionsUpdate"
      @dynamic-style-changed="styleUpdate"
      <gantt-header slot="header"></gantt-header>
    </gantt-elastic>
    <pmpTaskdetails-modal ref="modalForm1"></pmpTaskdetails-modal>
    <pmp-c-s-union-modal ref="csModal"></pmp-c-s-union-modal>
    <pmpProjectManage-modal ref="modalForm2"></pmpProjectManage-modal>
  </div>
</template>

<style>
</style>

<script>
import moment from 'moment'
import GanttElastic from 'gantt-elastic'
import GanttHeader from 'gantt-elastic-header'
import dayjs from 'dayjs'
import PmpTaskdetailsModal from '@views/jgzhu/project/modules/PmpTaskdetailsModal'
import PmpCommentSummaryModal from '@views/wqc/modules/PmpCommentSummaryModal'
import PmpCSUnionModal from '../../wqc/modules/PmpCSUnionModal'
import PmpProjectManageModal from '@views/jgzhu/project/modules/PmpProjectManageModal'

// just helper to get current dates
function getDate(hours) {
  const currentDate = new Date()
  const currentYear = currentDate.getFullYear()
  const currentMonth = currentDate.getMonth()
  const currentDay = currentDate.getDate()
  const timeStamp = new Date(currentYear, currentMonth, currentDay, 0, 0, 0).getTime()
  return new Date(timeStamp + hours * 60 * 60 * 1000).getTime()
}
let that
const options = {
  taskMapping: {
    progress: 'percent'
  },
  maxRows: 100,
  maxHeight: 700,
  title: {
    label: 'pmp 甘特图',
    html: false
  },
  row: {
    height: 24
  },
  calendar: {
    hour: {
      display: false
    }
  },
  chart: {
    progress: {
      bar: false
    },
    expander: {
      display: true
    }
  },
  taskList: {
    expander: {
      straight: false
    },
    columns: [
      {
        id: 2,
        label: '任务名',
        value: 'label',
        width: 200,
        expander: true,
        html: true,
        events: {
          click({ data, column }) {
            if (data.type == 'task') {
              that.handleDetail1(data)
            } else {
              that.handleDetail2(data)
            }
          }
        }
      },
      {
        id: 3,
        label: '负责人',
        value: 'user',
        width: 130,
        html: true,
        style: {
          'task-list-header-label': {
            'text-align': 'center',
            width: '100%'
          },
          'task-list-item-value-container': {
            'text-align': 'center',
            width: '100%'
          }
        },
        events: {
          click({ data, column }) {

            that.handleCommentSummary(data)
          }
        }
      },
      {
        id: 4,
        label: '类型',
        value: 'realprojecttype',
        width: 130,
        html: true,
        style: {
          'task-list-header-label': {
            'text-align': 'center',
            width: '100%'
          },
          'task-list-item-value-container': {
            'text-align': 'center',
            width: '100%'
          }
        }
      },
      {
        id: 5,
        label: '开始日期',
        value: 'start',
        width: 78,
        style: {
          'task-list-header-label': {
            'text-align': 'center',
            width: '100%'
          },
          'task-list-item-value-container': {
            'text-align': 'center',
            width: '100%'
          }
        }
      },
      {
        id: 6,
        label: '时长',
        value: 'dayDuration',
        width: 45,
        style: {
          'task-list-header-label': {
            'text-align': 'center',
            width: '100%'
          },
          'task-list-item-value-container': {
            'text-align': 'center',
            width: '100%'
          }
        }
      },
      {
        id: 7,
        label: '%',
        value: 'progress',
        width: 35,
        style: {
          'task-list-header-label': {
            'text-align': 'center',
            width: '100%'
          },
          'task-list-item-value-container': {
            'text-align': 'center',
            width: '100%'
          }
        }
      }
    ]
  },
  locale: {
    // name: "en",
    // Now: "Now",
    // "X-Scale": "Zoom-X",
    // "Y-Scale": "Zoom-Y",
    // "Task list width": "Task list",
    // "Before/After": "Expand",
    // "Display task list": "Task list"
    weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
    months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
  }
}

export default {
  name: 'PmpGanttElasticModel',
  components: {
    GanttElastic,
    GanttHeader,
    PmpTaskdetailsModal,
    PmpCommentSummaryModal,
    PmpProjectManageModal,
    PmpCSUnionModal
  },
  props: {
    dataSource: {
      type: Array,
      require: true
    }
  },
  data() {
    return {
      options,
      dynamicStyle: {
        'task-list-header-label': {
          'font-weight': 'bold'
        }
      }
    }
  },
  mounted() {
    that = this
  },
  methods: {
    handleCommentSummary(record) {
        this.$refs.csModal.edit(record)
        this.$refs.csModal.disableSubmit = false
        this.$refs.csModal.description = record.projecttype
    },
    handleDetail1: function(record) {
      console.log('record', record)
      this.$refs.modalForm1.edit(record)
      this.$refs.modalForm1.title = '详情'
      this.$refs.modalForm1.disableSubmit = true
    },
    handleDetail2: function(record) {
      console.log('record', record)
      this.$refs.modalForm2.edit(record)
      this.$refs.modalForm2.title = '详情'
      this.$refs.modalForm2.disableSubmit = true
    },
    tasksUpdate(tasks) {
      this.dataSource = tasks
    },
    optionsUpdate(options) {
      this.options = options
    },
    styleUpdate(style) {
      this.dynamicStyle = style
    }
  }
}
</script>