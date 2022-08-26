package com.media.service;

import com.media.vo.Music;
import com.media.vo.Mv;

import java.util.Random;  // 셔플 함수 제작용.

public class MediaService {
	public String[] getMusicTitle(Music[] music) {
		// 전체 음악 title 목록을 return
		
		String[] temp = new String[music.length];
		
		int idx = 0;
		for (Music u: music)
			temp[idx++] = u.getMusicTitle();
		
		// null array 처리용 코드
		String[] tmp = new String[idx];
		System.arraycopy(temp, 0, tmp, 0, idx);
		
		return tmp;
	}
	
	public int[] getMvTime(Mv[] mv) {
		// 전체 mv의 재생시간 목록을 return
		
		int[] temp = new int[mv.length];
		
		int idx = 0;
		for (Mv v: mv)
			temp[idx++] = v.getMvTime();
		
		// null array 처리용 코드
		int[] tmp = new int[idx];
		System.arraycopy(temp, 0, tmp, 0, idx);
		
		return tmp;
	}
	
	public Music[] searchMusicBySinger(Music[] music, String singer) {
		// 음악에서 singer에 따른 music 목록을 return
		
		Music[] temp = new Music[music.length];
		
		int idx = 0;
		for (Music u: music)
			if (u.getMusicSinger() == singer) temp[idx++] = u;
		
		// null array 처리용 코드
		Music[] tmp = new Music[idx];
		System.arraycopy(temp, 0, tmp, 0, idx);
		
		return tmp;
	}
	
	public Mv[] searchMvByLike(Mv[] mv, int like) {
		// mv에서 특정 like 이상인 mv 목록을 return
		
		Mv[] temp = new Mv[mv.length];
		
		int idx = 0;
		for (Mv v: mv)
			if (v.getMvLike() >= like) temp[idx++] = v;
		
		// null array 처리용 코드
		Mv[] tmp = new Mv[idx];
		System.arraycopy(temp, 0, tmp, 0, idx);
		
		return tmp;
	}
	
	public int getAvgTimeByGenre(Music[] music, String genre) {
		// 음악에서 genre에 따른 average time을 return
		
		int timeSum = 0;
		int genreCount = 0;
		
		for (Music u: music)
			if (u.getMusicGenre() == genre) {
				timeSum += u.getMusicTime();
				genreCount++;
			}
		
		if (genreCount == 0) genreCount = 1;  // 0 나누기 방지용.
		
		return timeSum / genreCount;
	}
	
	public String getTotalLike(Music[] music, Mv[] mv) {
		// 음악과 mv 목록에서 제목+가수가 같은 정보들을 고려, 총 합 1순위 like인 것의 정보를 return
		
		// (임시) 정보 저장용 변수
		String[] temp = new String[music.length + mv.length];
		int[] tempLike = new int[music.length + mv.length];
		
		// 실제 정보를 저장하는 과정
		int idx = 0;
		for (Music u: music) {  // music에서 제목, 가수, 좋아요 정보를 추출
			temp[idx] = "제목: " + u.getMusicTitle() + ", 가수: " + u.getMusicSinger();
			tempLike[idx++] = u.getMusicLike();
		}
		for (Mv v: mv) {  // mv에서 제목, 가수, 좋아요 정보를 추출하되, 이중 탐색해서 정보가 있음 좋아요를 갱신
			boolean findData = false;
			String nowData = "제목: " + v.getMvTitle() + ", 가수: " + v.getMvSinger();
			for (int tmpIdx = 0; tmpIdx < idx; tmpIdx++)
				if (temp[tmpIdx] == nowData) {
					// 만일 동일 정보가 찾은 경우, music like 정보에 mv like 정보를 더하기
					tempLike[tmpIdx] += v.getMvLike();
					findData = true;
					break;
				}
			
			if (!findData) {  // 만일 중복 정보가 없는 경우엔 새로 정보 추가.
				temp[idx] = "제목: " + v.getMvTitle() + ", 가수: " + v.getMvSinger();
				tempLike[idx++] = v.getMvLike();
			}
		}
		
		// 얻어낸 정보로 최종 결과를 도출. 동률의 경우 가장 상단에 나온 데이터(Music -> Mv) 우선.
		String totalLikeInfo = "";
		int maxTotalLike = 0;
		for (int newIdx = 0; newIdx < idx; newIdx++) {
			if (maxTotalLike < tempLike[newIdx]) {
				totalLikeInfo = temp[newIdx];
				maxTotalLike = tempLike[newIdx];
			}
		}
		
		return totalLikeInfo;
	}
	
	public String[] shuffleMedia(Music[] music, Mv[] mv) {
		int fullLen = music.length + mv.length;
		String[] temp = new String[fullLen];
		
		int idx = 0;
		for (Music u: music)  // music에서 제목, 가수, 정보를 추출
			temp[idx++] = "[음악] 제목: " + u.getMusicTitle() + ", 가수: " + u.getMusicSinger();
		for (Mv v: mv)  // music에서 제목, 가수, 좋아요 정보를 추출
			temp[idx++] = "[MV] 제목: " + v.getMvTitle() + ", 가수: " + v.getMvSinger();
		
		Random rand = new Random();
		int[] idxList = new int[fullLen];
		for (int i=0; i<fullLen; ) {
			int data = rand.nextInt(fullLen);  // 일단 뽑고
			
			boolean isDup = false;
			for (int j=0; j<i; j++)
				if (idxList[j] == data) {  // idx 중복 발생시.
					isDup = true;
					break;
				}
			
			if (!isDup) idxList[i++] = data;  // idx 중복이 없으면 새로 넣기.
		}
		
		String[] newTemp = new String[fullLen];  // 결과 배열
		for (int i=0; i<fullLen; i++) newTemp[i] = temp[idxList[i]];
		// 새로운 데이터 = 기존 데이터(랜덤 인덱스)
		
		return newTemp;
	}
}