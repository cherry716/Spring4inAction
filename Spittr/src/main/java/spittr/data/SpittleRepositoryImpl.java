package spittr.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        // TODO Auto-generated method stub
        return null;
    }

}
