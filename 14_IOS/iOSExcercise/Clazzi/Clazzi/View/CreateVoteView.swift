//
//  CreateVoteView.swift
//  Clazzi
//
//  Created by Admin on 8/26/25.
//

import SwiftUI

struct CreateVoteView: View {
    @State private var title: String = ""
    @State private var options: [String] = ["", ""]
    
    var body: some View {
        NavigationStack {
            VStack {
                ScrollView {
                    VStack {
                        TextField("투표 제목", text: $title)
                            .textFieldStyle(RoundedBorderTextFieldStyle())
                            .padding()
                            .background(
                                RoundedRectangle(cornerRadius: 8)
                                    .stroke(Color.gray, lineWidth: 1)
                            )
                            .padding(.bottom, 16)
                        Text("투표 항목")
                            .font(.headline)
                        
                        ForEach(options.indices, id: \.self) { index in
                            TextField("항목 \(index + 1)", text: $options[index])
                                .padding()
                                .background(
                                    RoundedRectangle(cornerRadius: 8)
                                        .stroke(Color.gray, lineWidth: 1)
                                )
                        }
                        
                        Button("항목 추가") {
                            
                        }
                        .buttonStyle(.bordered)
                        .frame(maxWidth: .infinity, alignment: .trailing)
                        Spacer()
                    }
                    .navigationTitle(Text("투표 생성 화면"))
                }
                // 생성하기 버튼
                Button(action: {}) {
                    Text("생성하기")
                        .frame(maxWidth: .infinity)
                        .padding()
                        .background(.blue)
                        .foregroundColor(.white)
                        .cornerRadius(8)
                }
            }
            .padding()
        }
    }
}

#Preview {
    CreateVoteView()
}
