//
//  ContentView.swift
//  Navigation
//
//  Created by Admin on 8/19/25.
//

import SwiftUI

struct ContentView: View {
    @State private var isActive: Bool = false
    
    var body: some View {
        NavigationStack {
            ScrollView {
                VStack {
                    NavigationLink("다음 화면으로 이동", destination: DetailView())
                        .padding(.bottom, 20)
                    
                    NavigationLink("다음 화면으로 이동2", destination: Text("이것 역시 상세 화면입니다."))
                        .padding(.bottom, 20)
                    
                    // 버튼으로 이동
                    Button("버튼으로 다음 화면으로 이동 ") {
                        isActive = true
                    }
                    NavigationLink("", destination: DetailView(), isActive: $isActive)
                    
                    // 이동할 때 누르는 커스텀 뷰의 코드가 많을 때 유리하다.
                    NavigationLink {
                        // 목적지 뷰
                        DetailView()
                    } label: {
                        Text("다음 화면으로 이동")
                    }
                }
                .navigationTitle("홈")
                .padding()
            }
        }
    }
}

struct DetailView: View {
    // 속성 래퍼(Property Wrapper)
    @Environment(\.dismiss) var dismiss
    
    var body: some View {
        VStack {
            Text("상세 화면입니다.")
            Button("뒤로 가기") {
                dismiss()
            }
        }
    }
}

#Preview {
    ContentView()
}
