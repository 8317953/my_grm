package com.haut.grm.repository.meta;

import com.haut.grm.model.meta.SmsTemplate;
import com.haut.grm.repository.base.BaseEntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public abstract interface SmsTemplateRepository
  extends BaseEntityRepository<SmsTemplate, Long>
{}


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\repository\meta\SmsTemplateRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */