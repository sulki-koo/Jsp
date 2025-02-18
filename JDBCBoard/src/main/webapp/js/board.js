const board = {
	getReplyList: function(aid) {
		axios.get('/selectReply.do?aid=' + aid)
			.then(response => {
				this.printReplyList(response.data, aid);
			})
	},
	deleteReply : function (rid, aid) {
		axios.get('/deleteReply.do?rid='+rid).then(()=> this.getReplyList(aid));
	},
	printReplyList: function(data, aid) {
		if (data) {
			let ulHtml = '';
				for (reply of data) {
					if (aid == reply.aid) {
						const dateStr = `${reply.rregdate}`;
						let datePrintStr = dayjs(dateStr).format('YY.MM.DD HH:mm');
						ulHtml += `<li>[${reply.mid}]<br>${reply.rcontent}<br> ${datePrintStr}`;
						ulHtml += `&nbsp;<a href="javascript:board.deleteReply(${reply.rid}, ${aid})">[삭제]</a></li>`;
				}
			}
			$('#replyList').html(ulHtml);
		}
	}
};





