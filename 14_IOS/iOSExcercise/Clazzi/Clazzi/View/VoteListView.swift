//
//  VoteView.swift
//  Clazzi
//
//  Created by Admin on 8/26/25.
//

import SwiftUI

struct VoteListView: View {
    let votes = ["첫 번째 투표", "두 번째 투표", "세 번째 투표"]
    
    @State private var isPresentingCreate: Bool = false
    
    var body: some View {
        NavigationStack {
            ZStack {
                ScrollView {
                    LazyVStack(spacing: 16) {
                        ForEach(votes, id: \.self) { vote in
                            VoteCardView(vote: vote)
                        }
                    }
                }
                VStack {
                    Spacer()
                    HStack {
                        Spacer()
                        Button(action: {
                            isPresentingCreate.toggle()
                        }) {
                            Image(systemName: "plus")
                                .foregroundColor(.white)
                                .padding()
                                .background(Color.blue)
                                .clipShape(Circle())
                                .shadow(radius: 4)
                        }
                        .padding()
                    }
                }
            }
            .padding()
            .navigationBarTitle("투표 목록 확인")
            // 오른쪽 위 버튼
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    //                    NavigationLink(destination: CreateVoteView()) {
                    //                        Image(systemName: "plus")
                    //                    }
                    
                    // 화면 이동 방법2: 상태를 이용한 이동 방법
                    Button(action: {
                        isPresentingCreate.toggle()
                    }) {
                        Image(systemName: "plus")
                    }
                }
            }
            .navigationDestination(isPresented: $isPresentingCreate) {
                CreateVoteView()
            }
            // 화면 이동 방법3: 모달을 활용한 화면 띄우는 방법 (상태 이용)
//            .sheet(isPresented: $isPresentingCreate) {
//                CreateVoteView()
//            }
        }
    }
}

struct VoteCardView: View {
    let vote: String
    var body: some View {
        VStack(alignment: .leading) {
            Text(vote)
                .font(.headline)
                .foregroundColor(.white)
            Text("투표 항목 보기")
                .font(.subheadline)
                .foregroundColor(.white)
        }
        .padding(16)
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(.gray)
        .cornerRadius(12)
        .shadow(color: .black.opacity(0.3), radius: 4, x: 2, y: 2)
    }
}

#Preview {
    VoteListView()
}
