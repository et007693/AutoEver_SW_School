//
//  ContentView.swift
//  profile
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            HStack {
                Image("clazzi")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 100, height: 100)
                    .background(Color.gray.opacity(0.3))
                    .cornerRadius(12)
                Spacer()
                VStack(alignment:.leading) {
                    Text("송창용")
                        .font(.title)
                    Text("개발자룰 꿈꾸는 학생입니다.")
                        .font(.subheadline)
                        .foregroundColor(.gray)
                }
                .padding()
                .background(Color.green.opacity(0.3))
                .cornerRadius(12)
                
            }
            .padding()
            .background(Color.yellow.opacity(0.3))
            .cornerRadius(16)
            Spacer()
            Text("메시지 보내기")
                .padding()
                .frame(maxWidth: .infinity) // 가로 전체 차지
                .background(Color.blue)
                .foregroundStyle(.white)
                .cornerRadius(10)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
