package net.asutosh.springboot;

import net.asutosh.springboot.entity.WikimidiaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private  static  final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private  WikimidiaDataRepository dataRepository;

    //Constructor based DI , in this class have one constructor that is why we do not need to give
//    @Autowired annotation


    public KafkaDatabaseConsumer(WikimidiaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "wikimidiaTopic_1",
            groupId= "myGroup"
    )
    public  void consume(String eventMessage){

       LOGGER.info(String.format("Message receieved successfully -> %s" , eventMessage));

        WikimidiaData wikimidiaData = new WikimidiaData();
        wikimidiaData.setWikimidiaEventData(eventMessage);

        dataRepository.save(wikimidiaData);
    }
}
