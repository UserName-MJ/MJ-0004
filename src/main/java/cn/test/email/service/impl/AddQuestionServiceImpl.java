package cn.test.email.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.jedis.JedisClientPool;
import cn.test.email.mapping.AddQuestionMapper;
import cn.test.email.model.TQuestion;
import cn.test.email.service.AddQuestionService;
import cn.test.email.utils.JsonUtils;

@Service
public class AddQuestionServiceImpl implements AddQuestionService {

	@Autowired
	private AddQuestionMapper addQuestionMapper;

	@Override
	public void addQuestion(TQuestion tQuestion) {
		// TODO Auto-generated method stub

		addQuestionMapper.addQuestion(tQuestion);
	}

	@Override
	public List<TQuestion> findAll() {
		// TODO Auto-generated method stub
		List<TQuestion> list = addQuestionMapper.findAll();

		for (TQuestion teq : list) {
			String option = teq.get_option();
			if (option != null) {

				String[] split = option.split(",");
				List<String> ops = teq.getOps();
				for (int i = 0; i < split.length; i++) {
					ops.add(split[i]);
				}

			}
		}

		return list;
	}

	/**
	 * 半自动添加试题
	 */
	@Override
	public void addQuestionVo(Integer[] qid, Integer pid) {
		// TODO Auto-generated method stub
		TQuestion tq = new TQuestion();
		for (int i = 0; i < qid.length; i++) {
			tq.setId(qid[i]);
			tq.setPid(pid);
			addQuestionMapper.addPaperQuestion(tq);
		}

	}

	/**
	 * 把缓存中的试题保存到数据库中
	 *
	 */
	@Override
	public void saveQuestion(TQuestion tQuestion) {
		// TODO Auto-generated method stub
		addQuestionMapper.saveQuestion(tQuestion);
		
		
	}

	@Override
	public void addPaperQuestion(TQuestion tQuestion) {
		// TODO Auto-generated method stub
		addQuestionMapper.addPaperQuestion(tQuestion);
	}


	

}
