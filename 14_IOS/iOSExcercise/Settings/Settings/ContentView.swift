//
//  ContentView.swift
//  Settings
//
//  Created by Admin on 8/26/25.
//

import SwiftUI

struct ContentView: View {
    @State private var searchText: String = ""
    @State private var isAirplaneModeOn: Bool = false
    var body: some View {
        NavigationSplitView {
            List {
                ProfileRow(title: "송창용")
                
                Section {
                    SettingRow(title: "비행기 모드", icon: "airplane", iconColor:.orange, destination: AnyView(AirplaneView()), toggleState: $isAirplaneModeOn)
                    SettingRow(title: "Wi-Fi", subtitle: "연결된 네트워크", icon: "wifi", iconColor:.blue, destination: AnyView(BluetoothView()))
                    SettingRow(title: "Bluetooth", subtitle: "연결된 Bluetooth", icon: "", iconColor:.blue)
                    SettingRow(title: "셀룰러", icon: "antenna.radiowaves.left.and.right", iconColor:.green)
                }
                
                Section(header: Text("알림")) {
                    SettingRow(title: "알림", icon: "bell.badge.fill", iconColor:.red)
                    SettingRow(title: "사운드 및 햅틱", icon: "speaker.wave.3.fill", iconColor:.purple)
                }
                
                Section(header: Text("일반")) {
                    SettingRow(title: "일반", icon: "gear", iconColor:.orange)
                    SettingRow(title: "손쉬운 사용", icon: "hand.raised.fill", iconColor:.blue)
                    SettingRow(title: "개인정보 보호 및 보안", icon: "lock.fill", iconColor:.gray)
//                    SettingRow(title: "동작 버튼", icon: "airplane")
//                    SettingRow(title: "스탠바이", icon: "airplane")
//                    SettingRow(title: "카메라", icon: "airplane")
//                    SettingRow(title: "홈 화면 및 앱 보관함", icon: "airplane")
//                    SettingRow(title: "Apple Intelligence 및 Siri", icon: "airplane")
                }
            }
            .navigationTitle(Text("설정"))
            .searchable(text: $searchText, prompt: "검색")
        } detail: {
            Text("항목을 선택해주세요.")
        }

    }
}
struct ProfileRow: View {
    var title: String
    var hasNavigation: Bool = true
    
    var content: some View {
        HStack {
            Image(systemName: "person.crop.circle.fill")
                .resizable()
                .frame(width: 44, height: 44)
                .foregroundColor(.blue)
                .padding(.vertical, 4)
                .padding(.trailing, 4)
            
            VStack(alignment: .leading) {
                Text(title)
                Text("Apple ID, iCloud, 미디어 및 구입")
                    .font(.subheadline)
                    .foregroundColor(.gray)
            }
        }
    }
    
    var body: some View {
        NavigationLink(destination: Text(title)) {
            content
        }
    }
}

struct SettingRow: View {
    let title: String
    var subtitle: String? = nil
    let icon: String
    let iconColor: Color
    let hasNavigation: Bool = true
    var destination: AnyView = AnyView(Text("세팅 항목 화면"))
    var hasToggle: Bool = false
    var toggleState: Binding<Bool>? = nil
    
    var content: some View {
        HStack {
            Image(systemName: icon)
                .frame(width: 32, height: 32)
                .foregroundColor(.white)
                .background(iconColor)
                .clipShape(RoundedRectangle(cornerRadius: 8))
            
            VStack(alignment: .leading) {
                Text(title)
                if let subtitle = subtitle {
                    Text(subtitle)
                        .font(.subheadline)
                        .foregroundColor(.gray)
                }
            }
            
            Spacer()
            
            if let toggleState = toggleState {
                Toggle("", isOn: toggleState)
                    .labelsHidden()
            }
        }
        
        .frame(minHeight: 40)
    }

    var body: some View {
        if hasNavigation {
            NavigationLink(destination: Text("\(title) 화면")) {
                content
            }
        } else {
            content
        }
    }
}

#Preview {
    ContentView()
}
