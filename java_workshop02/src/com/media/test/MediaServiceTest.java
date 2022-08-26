package com.media.test;

import com.media.vo.Music;
import com.media.vo.Mv;
import com.media.service.MediaService;

public class MediaServiceTest {
	public static void main(String[] args) {
		// 음악 차트 생성
		Music[] msList = {
				new Music("좋은날", "아이유", "댄스", 300),
				new Music("신호등", "이무진", "발라드", 320),
				new Music("소주한잔", "임창정", "발라드", 250),
				new Music("밤편지", "아이유", "발라드", 360),
				new Music("사랑은 늘 도망가", "임영웅", "트로트", 400)
		};
		// 뮤비 차트 생성
		Mv[] mvList ={
		        new Mv("좋은날", "아이유", 350),
		        new Mv("으르렁", "EXO", 300),
		        new Mv("아로하", "조정석", 380),
		        new Mv("소주한잔", "임창정", 260),
		        new Mv("이제 나만 믿어요", "임영웅", 200),
		};
		
		// 음악 좋아요 항목 set
		msList[0].setMusicLike(100);
		msList[1].setMusicLike(50);
		msList[2].setMusicLike(70);
		msList[3].setMusicLike(200);
		msList[4].setMusicLike(300);
		// 뮤비 좋아요 항목 set
		mvList[0].setMvLike(50);
		mvList[1].setMvLike(200);
		mvList[2].setMvLike(60);
		mvList[3].setMvLike(70);
		mvList[4].setMvLike(200);
		
		// 서비스 생성
		MediaService service = new MediaService();
		
		// 1
		System.out.println("\n==전체 음악 목록에서 음악 제목 목록 받기==");
		for(Music ms :msList) System.out.println(ms.getMusicTitle());
		
		// 2
		System.out.println("\n==전체 MV 목록에서 재생시간 목록 받기==");
		for(Mv mv :mvList) System.out.println(mv.getMvTitle()+" : "+mv.getMvTime()+"초");
		
	    // 3.
		System.out.println("\n==전체 음악 목록에서 아이유가 부른 노래 찾기==");
		Music[] iuList = service.searchMusicBySinger(msList, "아이유");
	    for(Music ms : iuList) {
	        System.out.println(ms.getMusicTitle());
	    }
	    
	    // 4.
		System.out.println("\n==전체 뮤비 목록에서 좋아요가 70 이상인 것을 검색==");
		Mv[] likeList = service.searchMvByLike(mvList, 80);
	    for(Mv ml : likeList) {
	        System.out.println(ml.getMvSinger()+" : "+ml.getMvTitle());
	    }
	    
		// 5
		System.out.println("\n==음악 목록에서 발라드 장르의 평균 재생 시간 받기==");
		System.out.println(service.getAvgTimeByGenre(msList, "발라드"));
		
		// 6.
		System.out.println("\n==전체 음악, 뮤비 목록에서 가장 좋아요가 많은 미디어를 검색==");
		System.out.println(service.getTotalLike(msList, mvList));
		
		// 7
		System.out.println("\n==랜덤 플레이리스트 목록 받기==");
		System.out.println(service.shuffleMedia(msList, mvList));
	}
}
