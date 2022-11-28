# hardhat-conflux-demo

本项目是在 Conflux 链上使用 Hardhat 进行合约部署的 demo。想要运行本项目，需要
- 运行 `npm install` 安装依赖；
- 运行 `npm install dotenv -D` 命令安装 dotenv 模块；
- 在根目录下创建 .env 文件，以 `PRIVATE_KEY1=0x..` 的形式引入自己的私钥；
- 运行 `npx hardhat compile` 编译合约；
- 运行 `npx hardhat run scripts/sample-deploy.js --network confluxTestnet` 部署合约
- 运行 `npx hardhat run scripts/sample-transfer.js --network confluxTestnet` 进行空投

如果遇到问题，可参考
- Hardhat 官方教程: https://hardhat.org/tutorial
- hardhat-conflux 安装使用说明: https://github.com/conflux-chain/hardhat-conflux
- Conflux数字藏品开发入门指南：https://conflux-technical-support.gitbook.io/conflux-nft-kai-fa-zhi-nan/step-4-zai-lian-shang-bu-shu-ni-de-he-yue/shi-yong-hardhat-bu-shu-he-yue
